package com.libsysbackend.libsysbackend.entity.Borrower;

import com.google.gson.Gson;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class BorrowerDAO {

    private final JdbcTemplate jdbcTemplate;

    public BorrowerDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String getAllBorrowers(){
        String query = "select borrower.borrowerID, borrower.name, borrower.lastName, borrower.SSN, borrowercontact.epost, borrowercontact.tel, borrower.role, borrowercredentials.borrowerPassword from ((borrower inner join borrowercontact on borrower.borrowerID = borrowercontact.borrowerID) inner join borrowercredentials on borrower.borrowerID = borrowercredentials.borrower_BorrowerID)";

        ArrayList<Borrower>borrowers = new ArrayList<>();
        List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);
        for (Map<String, Object> row : rows){
            Borrower borrower = new Borrower(
                    (Integer) row.get("borrowerID"),
                    (String) row.get("name"),
                    (String) row.get("lastname"),
                    (String) row.get("SSN"),
                    (String) row.get("email"),
                    (String) row.get("tel"),
                    (String) row.get("role"),
                    (String) row.get("borrowerPassword")
            );
            borrowers.add(borrower);
        }
        return new Gson().toJson(borrowers);
    }
    public String getBorrowerBySSN(String ssn_in){
        String query = "select borrower.borrowerID, borrower.name, borrower.lastName, borrower.SSN, borrowercontact.epost, borrowercontact.tel, borrower.role, borrowercredentials.borrowerPassword from (( borrower inner join borrowercontact on borrower.borrowerID = borrowercontact.borrowerContactID) inner join borrowercredentials on borrower.borrowerID = borrowercredentials.borrower_BorrowerID) where borrower.SSN = ?";
        Borrower borrower = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Borrower(
                rs.getInt("borrowerID"),
                rs.getString("name"),
                rs.getString("lastName"),
                rs.getString("SSN"),
                rs.getString("epost"),
                rs.getString("tel"),
                rs.getString("role"),
                rs.getString("borrowerPassword")
        ), ssn_in);
        return new Gson().toJson(borrower);
    }
    public String updateBorrowerContactBySSN(String ssn_in, String newEpost, String newTel){
        String query = "UPDATE borrowercontact SET epost = ?, tel = ? WHERE borrowercontact.borrowerID = ?";
        if (this.jdbcTemplate.update(query, newEpost, newTel, ssn_in) > 0){
            return "updated borrowers";
        }
        return "could not update borrower";
    }
    public String updateBorrowerPasswordBySSN(String ssn_in, String newPassword){
        String query = "UPDATE borrowercredentials SET borrowerPassword = ? WHERE borrower_BorrowerID = ?";
        if (this.jdbcTemplate.update(query, newPassword, ssn_in) > 0){
            return "password updated!";
        }else{
            return "could not update password";
        }
    }

     public Boolean verifyBorrower(String ssn_in, String password){
        String query = "select borrower.borrowerID from borrower inner join borrowercredentials on borrower.SSN = ? and borrowercredentials.borrowerPassword = ?";

        try {
            Borrower borrower = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Borrower(
                    rs.getInt("borrowerID")
            ), ssn_in, password);
        } catch (EmptyResultDataAccessException e){
            return false;
        }
        return true;
    }
}

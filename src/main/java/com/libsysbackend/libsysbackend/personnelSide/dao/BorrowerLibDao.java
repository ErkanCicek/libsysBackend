package com.libsysbackend.libsysbackend.personnelSide.dao;

import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BorrowerLibDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<BorrowerLib> getAllBorrowers() {
		String query = "SELECT * FROM borrower";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<BorrowerLib> borrowerList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			BorrowerLib borrowerLib = new BorrowerLib(Integer.parseInt(row.get("borrowerID").toString()),
					(String) row.get("name"),
					(String) row.get("lastName"),
					(String) row.get("SSN"),
					(String) row.get("epost"),
					(String) row.get("tel"));
			borrowerList.add(borrowerLib);
		}
		return borrowerList;
	}
	
	public BorrowerLib getBorrowerByBorrowerID(String borrowerID) {
		String query = "SELECT * FROM borrower WHERE borrowerID = ? LIMIT 1";
		
		BorrowerLib borrowerLib = jdbcTemplate.queryForObject(query,  new RowMapper<BorrowerLib>() {
			@Override
			public BorrowerLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				BorrowerLib borrowerLib = new BorrowerLib(rs.getInt("borrowerID"),
						rs.getString("name"),
						rs.getString("lastName"),
						rs.getString("SSN"));
				
				return borrowerLib;
			}
		}, borrowerID);
		
		return borrowerLib;
	}
	
	public String deleteBorrowerByID(String borrowerID) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_borrower");
		Integer borrowerIDToInt = Integer.parseInt(borrowerID);
		String returnable = String.valueOf(simpleJdbcCall.execute(borrowerIDToInt));
		
		return returnable;
	}
	
	public void addBorrower(String name, String lastName, String SSN, String email, String phoneNr)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String borrowerNameSpaceFixed = name.replace("WHITESPACEHEREX", " ");
		String borrowerLastNameSpaceFixed = lastName.replace("WHITESPACEHEREX", " ");
		String borrowerSSNSpaceFixed = SSN.replace("WHITESPACEHEREX", " ");
		String borrowerEmailSpaceFixed = email.replace("WHITESPACEHEREX", " ");
		String borrowerPhoneNrSpaceFixed = phoneNr.replace("WHITESPACEHEREX", " ");
		
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_borrower");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("borrowerName", borrowerNameSpaceFixed);
		inParameters.put("borrowerLastName", borrowerLastNameSpaceFixed);
		inParameters.put("borrowerSSN", borrowerSSNSpaceFixed);
		inParameters.put("borrowerEmail", borrowerEmailSpaceFixed);
		inParameters.put("borrowerPhoneNr", borrowerPhoneNrSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public void addBorrowerCredentials(String borrower_BorrowerID, String borrowerPassword)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String borrowerCredentialsBorrowerIDNameSpaceFixed = borrower_BorrowerID.replace("WHITESPACEHEREX", " ");
		String borrowerCredentialsPWSpaceFixed = borrowerPassword.replace("WHITESPACEHEREX", " ");
		
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_borrowerCredentials");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("bID", borrowerCredentialsBorrowerIDNameSpaceFixed);
		inParameters.put("pw", borrowerCredentialsPWSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
}
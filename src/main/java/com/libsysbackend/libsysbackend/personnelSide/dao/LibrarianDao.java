package com.libsysbackend.libsysbackend.personnelSide.dao;

import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
import com.libsysbackend.libsysbackend.personnelSide.model.Librarian;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class LibrarianDao extends JdbcDaoSupport {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	private void initialize() {
		setJdbcTemplate(jdbcTemplate);
	}
	
	public List<Librarian> getAllPersonel() {
		String query = "SELECT * FROM personel";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<Librarian> personelList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			Librarian librarian = new Librarian(Integer.parseInt(row.get("personelID").toString()),
					(String) row.get("name"),
					(String) row.get("lastName"),
					(String) row.get("SSN"),
					(String) row.get("ROLE"));
			personelList.add(librarian);
		}
		return personelList;
	}
	
	public void addPersonel(String name, String lastName, String SSN, String ROLE, String email, String phoneNr) {
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String personelNameSpaceFixed = name.replace("WHITESPACEHEREX", " ");
		String personelLastNameSpaceFixed = lastName.replace("WHITESPACEHEREX", " ");
		String personelSSNSpaceFixed = SSN.replace("WHITESPACEHEREX", " ");
		String personelROLESpaceFixed = ROLE.replace("WHITESPACEHEREX", " ");
		String personelEmailSpaceFixed = email.replace("WHITESPACEHEREX", " ");
		String personelPhoneNrSpaceFixed = phoneNr.replace("WHITESPACEHEREX", " ");
		
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_personel");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("personelName", personelNameSpaceFixed);
		inParameters.put("personelLastName", personelLastNameSpaceFixed);
		inParameters.put("personelSSN", personelSSNSpaceFixed);
		inParameters.put("personelROLE", personelROLESpaceFixed);
		inParameters.put("personelEmail", personelEmailSpaceFixed);
		inParameters.put("personelPhoneNr", personelPhoneNrSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public void addPersonelCredentials(String personelID, String password)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String personelCredentialsPersonelIDNameSpaceFixed = personelID.replace("WHITESPACEHEREX", " ");
		String personelCredentialsPWSpaceFixed = password.replace("WHITESPACEHEREX", " ");
		
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_personelCredentials");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("personelID", personelCredentialsPersonelIDNameSpaceFixed);
		inParameters.put("pw", personelCredentialsPWSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public String deletePersonelByID(String personelID) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_personel");
		Integer personelIDToInt = Integer.parseInt(personelID);
		String returnable = String.valueOf(simpleJdbcCall.execute(personelIDToInt));
		
		return returnable;
	}
	
	public Librarian getPersonelById(String personelID) {
		String query = "SELECT * FROM personel WHERE personelID = ? LIMIT 1";
		
		Librarian librarian = jdbcTemplate.queryForObject(query, new RowMapper<Librarian>() {
			@Override
			public Librarian mapRow(ResultSet rs, int rowNum) throws SQLException {
				Librarian librarian = new Librarian(rs.getInt("personelID"),
						rs.getString("name"),
						rs.getString("lastName"),
						rs.getString("SSN"),
						rs.getString("ROLE"));
				
				return librarian;
			}
		}, personelID);
		
		return librarian;
	}
	
	public String getValidationNumber(){
		String query = "SELECT * FROM user_validation";
		
		String answer = String.valueOf(jdbcTemplate.queryForList(query));
		
		return answer;
	}
	
	public String libLogin (String personelID, String password){
		String personelIDSpaceFixed = personelID.replace("WHITESPACEHEREX", " ");
		String passwordSpaceFixed = password.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("login_verification");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("pID", personelIDSpaceFixed);
		inParameters.put("pw", passwordSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		String returnable = String.valueOf(simpleJdbcCall.execute(in));
		
		return returnable;
	}
	
	public Librarian getRoleById(String personelID) {
		String query = "SELECT ROLE FROM libsys.personel WHERE personelID = ?";
		
		Librarian librarian = jdbcTemplate.queryForObject(query, new RowMapper<Librarian>() {
			@Override
			public Librarian mapRow(ResultSet rs, int rowNum) throws SQLException {
				Librarian librarian = new Librarian(rs.getString("ROLE"));
				
				return librarian;
			}
		}, personelID);
		
		return librarian;
	}
}

package com.libsysbackend.libsysbackend.personnelSide.dao;

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
import java.util.HashMap;
import java.util.Map;

@Repository
public class LibrarianDao extends JdbcDaoSupport {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@PostConstruct
	private void initialize() {
		setJdbcTemplate(jdbcTemplate);
	}
	
	public Librarian getPersonelById(String personelID) {
		String query = "SELECT * FROM personel WHERE personelID = ?";
		
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
	
	public void libLogin (String personelID, String password){
		String personelIDSpaceFixed = personelID.replace("WHITESPACEHEREX", " ");
		String passwordSpaceFixed = password.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("login_verification");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("pID", personelIDSpaceFixed);
		inParameters.put("pw", passwordSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		String.valueOf(simpleJdbcCall.execute(in));
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

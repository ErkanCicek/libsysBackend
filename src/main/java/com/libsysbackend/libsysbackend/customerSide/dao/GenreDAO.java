package com.libsysbackend.libsysbackend.customerSide.dao;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class GenreDAO {

	@Autowired
	JdbcTemplate jdbcTemplate;

	public String getGenreByName(String genreName_in){
		String query = "SELECT * FROM genre WHERE genreName = ?";

		Genre genre = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Genre(
				rs.getInt("genreID"),
				rs.getString("genreName"),
				rs.getString("genreDesc")
		), genreName_in);
		return new Gson().toJson(genre);
	}
}

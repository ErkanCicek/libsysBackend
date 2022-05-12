package com.libsysbackend.libsysbackend.entity.Genre;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	public String getGenreById(int genreId_in){
		String query = "SELECT * FROM genre WHERE genreId = ?";

		Genre genre = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Genre(
				rs.getInt("genreId"),
				rs.getString("genreName"),
				rs.getString("genreDesc")
		), genreId_in);
		return new Gson().toJson(genre);
	}
	public String getAllGenre(){
		String query = "SELECT * FROM genre";
		ArrayList<Genre>genres = new ArrayList<>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);

		for (Map<String, Object> row : rows){
			Genre genre = new Genre(
					(Integer) row.get("genreId"),
					(String) row.get("genreName"),
					(String) row.get("genreDesc")
			);
			genres.add(genre);
		}
		return new Gson().toJson(genres);
	}
}

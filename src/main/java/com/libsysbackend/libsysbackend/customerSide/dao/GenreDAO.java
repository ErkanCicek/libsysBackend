package com.libsysbackend.libsysbackend.customerSide.dao;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository
public class GenreDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public String getGenreByID(int id){

        String query = "SELECT * FROM Genre WHERE Genre_id=?";

        Genre genre = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Genre(
                rs.getInt("GenreID"),
                rs.getString("GenreName"),
                rs.getString("GenreDesc")


        ), id);
        return new Gson().toJson(genre);


    }


}

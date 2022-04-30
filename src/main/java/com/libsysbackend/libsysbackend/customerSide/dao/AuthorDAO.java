package com.libsysbackend.libsysbackend.customerSide.dao;


import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;


@Repository
public class AuthorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String getAuthorById(int id){
        String query = "SELECT * FROM Author WHERE authorID = ?";
        Author author = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Author(
                rs.getInt("authorID"),
                rs.getString("authorName")
        ), id);
        return new Gson().toJson(author);
    }
    public String getAuthorByName(String authorName_in){
        String query = "SELECT * FROM author WHERE authorName = ?";
        Author author = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Author(
                rs.getInt("authorID"),
                rs.getString("authorName")
        ), authorName_in);
        return new Gson().toJson(author);
    }

}

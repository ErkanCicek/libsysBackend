package com.libsysbackend.libsysbackend.customerSide.dao;


import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.customerSide.model.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;



@Repository
public class AuthorDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;



    public String getAuthorById(int id){

        String query = "SELECT * FROM Author WHERE Author_id =?";

        Author author = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Author(
                rs.getInt("authorID"),
                rs.getString("authorName")


        ), id);
        return new Gson().toJson(author);
    }

}

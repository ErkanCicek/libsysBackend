package com.libsysbackend.libsysbackend.Author;


import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.Author.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


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
    public String getAllAuthors(){
        String query = "SELECT * FROM author";
        ArrayList<Author>authors = new ArrayList<>();
        List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows){
            Author author = new Author(
                    (Integer) row.get("authorID"),
                    (String) row.get("authorName")
            );
            authors.add(author);
        }
        return new Gson().toJson(authors);
    }

}

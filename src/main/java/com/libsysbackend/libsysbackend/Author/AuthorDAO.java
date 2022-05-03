package com.libsysbackend.libsysbackend.Author;


import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Repository
public class AuthorDAO {

    private final JdbcTemplate jdbcTemplate;

    public AuthorDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

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
        try {
            Author author = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Author(
                    rs.getInt("authorID"),
                    rs.getString("authorName")
            ), authorName_in);
            return new Gson().toJson(author);
        }catch (EmptyResultDataAccessException e){
            return "author does not exist";
        }
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
    public String insertNewAuthor(String name_in){
        String query = "INSERT IGNORE INTO author(authorName) value (?)";
            if (this.jdbcTemplate.update(query, URLDecoder.decode(name_in, StandardCharsets.UTF_8)) > 0) {
                return "author added";
            }
        return "author already exists";
    }
    public String deleteAuthorById(int id_in){
        String query = "DELETE FROM author WHERE author.authorID = ?";
        if (this.jdbcTemplate.update(query, id_in) > 0){
            return "author deleted";
        }
        return "could not delete author";
    }
    public String updateAuthorById(String newAuthorName_in, int id_in){
        String query = "UPDATE author SET authorName = ? WHERE authorID = ?";
        if (this.jdbcTemplate.update(query,newAuthorName_in,id_in) > 0){
            return "author updated";
        }
        return "could not update author";
    }
}

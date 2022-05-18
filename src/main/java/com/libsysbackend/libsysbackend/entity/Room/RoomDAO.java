package com.libsysbackend.libsysbackend.entity.Room;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.entity.Room.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RoomDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getRoomByName(String roomName_in){
        String query = "SELECT * FROM Room WHERE roomName =?";

        Room room = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Room(

                rs.getInt("roomID"),
                rs.getString("roomName"),
                rs.getString("DefaultTimeArray"),
                rs.getString("imageUrl")
        ), roomName_in);
        return new Gson().toJson(room);

    }
    public String getRoomById(int roomId_in){
        String query = "SELECT * FROM Room WHERE roomID =?";

        Room room = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Room(

                rs.getInt("roomID"),
                rs.getString("roomName"),
                rs.getString("defaultTimeArray"),
                rs.getString("imageUrl")
        ), roomId_in);
        return new Gson().toJson(room);

    }
    public String getAllRoom(){
        String query = "SELECT * FROM Room";
        ArrayList<Room> rooms = new ArrayList<>();
        List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows){
            Room room = new Room(
                    (Integer) row.get("roomID"),
                    (String) row.get("roomName"),
                    (String) row.get("DefaultTimeArray"),
                    (String) row.get("imageUrl")

            );
            rooms.add(room);
        } return new Gson().toJson(rooms);



    }





}


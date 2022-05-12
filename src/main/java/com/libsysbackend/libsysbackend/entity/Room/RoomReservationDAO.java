package com.libsysbackend.libsysbackend.Room;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Repository
public class RoomReservationDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public String getRoomReservationByName(String roomReservation_in){

        String query = "SELECT * FROM RoomReservation WHERE roomReservation";

        RoomReservation roomReservation = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new RoomReservation(

                rs.getInt("roomReservationID"),
                rs.getInt("roomID"),
                rs.getString("date"),
                rs.getString("timeArray")

        ), roomReservation_in );
        return new Gson().toJson(roomReservation);

    }
    public String getRoomReservationById(String roomReservationId_in){

        String query = "SELECT * FROM RoomReservation WHERE roomReservationID";

        RoomReservation roomReservation = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new RoomReservation(

                rs.getInt("roomReservationID"),
                rs.getInt("roomID"),
                rs.getString("date"),
                rs.getString("timeArray")

        ), roomReservationId_in);
        return new Gson().toJson(roomReservation);
    }

    public String getAllRoomReservation(){
        String query = "SELECT * FROM RoomReservation";
        ArrayList<RoomReservation> roomreservations = new ArrayList<>();
        List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query);

        for (Map<String, Object> row : rows){
            RoomReservation roomReservation = new RoomReservation(
                    (Integer) row.get("roomReservationID"),
                    (Integer) row.get("roomID"),
                    (String) row.get("date"),
                    (String) row.get("timeArray")
            );
            roomreservations.add(roomReservation);

        } return new Gson().toJson(roomreservations);


    }




}

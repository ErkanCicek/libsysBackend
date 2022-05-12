package com.libsysbackend.libsysbackend.Room;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomReservationDetailDAO {

    @Autowired
    JdbcTemplate jdbcTemplate;


    public String getRoomReservationDetailById(String roomReservationDetail_in){

        String query = "SELECT * FROM RoomReservationDetail WHERE idroomReservationDetail";

        RoomReservationDetail roomReservationDetail = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new RoomReservationDetail(

                rs.getInt("idroomreservationdetail"),
                rs.getString("time"),
                rs.getInt("borrower_borrowerID"),
                rs.getInt("roomreservationid")


        ), roomReservationDetail_in);
        return new Gson().toJson(roomReservationDetail);
    }



















}

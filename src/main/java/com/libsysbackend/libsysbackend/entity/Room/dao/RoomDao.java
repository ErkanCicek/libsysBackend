package com.libsysbackend.libsysbackend.entity.Room.dao;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.entity.Room.Room;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class RoomDao {

	private final JdbcTemplate jdbcTemplate;

	public RoomDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public String getRoomById(Integer roomId){
		String query = "SELECT * FROM room WHERE roomId = ?";
		try {
			Room room = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Room(
					rs.getInt("roomid"),
					rs.getString("roomname"),
					rs.getString("imageurl")
			), roomId);
			return new Gson().toJson(room);
		}catch (EmptyResultDataAccessException e){
			return "room does not exist";
		}
	}
}

package com.libsysbackend.libsysbackend.entity.Room;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class RoomDAO {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public String getRoomById(int roomId){
		String query = "SELECT * FROM room WHERE roomId = ?";
		Room room = this.jdbcTemplate.queryForObject(query, (rs, rowNum) -> new Room(
				rs.getInt("roomID"),
				rs.getString("roomName"),
				rs.getString("defaultTimeArray"),
				rs.getString("imageUrl")
		), roomId);
		return new Gson().toJson(room);
	}
}

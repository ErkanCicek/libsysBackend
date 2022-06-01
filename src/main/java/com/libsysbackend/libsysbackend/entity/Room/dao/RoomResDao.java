package com.libsysbackend.libsysbackend.entity.Room.dao;

import com.google.gson.Gson;
import com.libsysbackend.libsysbackend.entity.Room.RoomResDD;
import com.libsysbackend.libsysbackend.entity.Room.RoomResDate;
import com.libsysbackend.libsysbackend.entity.Room.RoomResDetail;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class RoomResDao {

	private final JdbcTemplate jdbcTemplate;


	public RoomResDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Integer> getNonAvaliableTimesByRoomIdAndRoomResDateId(Integer roomResId, Integer roomid){
		String query = "select roomreservationdetail.time from roomreservationdetail where roomreservationdetail.roomreservationdateID = ? and roomreservationdetail.room_roomID = ?";

		return this.jdbcTemplate.queryForList(query,Integer.class,roomResId, roomid);
	}

	public Integer getRoomResIdByDate(String dateIn){
		String query = "Select idroomreservationdate From roomreservationdate where dateValue = ?";
		try {
			return this.jdbcTemplate.queryForObject(query, Integer.class, dateIn);
		}catch (EmptyResultDataAccessException e){
			return 0;
		}
	}

	public void insertNewDateIntoRoomResDate(String currDate){
		String query = "Insert ignore into roomreservationdate(dateValue) value (?)";
		this.jdbcTemplate.update(query, currDate);
	}

	public String reserveStudyRoom(Integer roomResId, String time, Integer borrowerId, Integer roomId){
		String query = "insert into roomreservationdetail(roomreservationdateId, time, borrower_borrowerId, Room_roomid) values(?,?,?,?)";
		try {
			this.jdbcTemplate.update(query, roomResId, time, borrowerId, roomId);
		}catch (EmptyResultDataAccessException e){
			return "could not reserve room";
		}catch (DataIntegrityViolationException e){
			return "please log in before you book";
		}
		return "room has been reserved";
	}

	public String getAllReservationsBySSN(String SSN){
		String query = "SELECT roomreservationdate.dateValue, roomreservationdetail.time, roomreservationdetail.borrower_borrowerID, roomreservationdetail.room_roomID from roomreservationdate, roomreservationdetail inner join borrower on roomreservationdetail.borrower_borrowerID = borrower.borrowerID WHERE borrower.SSN = ?";
		ArrayList<RoomResDD> roomResDDS = new ArrayList<>();
		List<Map<String, Object>> rows = this.jdbcTemplate.queryForList(query, SSN);
		for (Map<String, Object> row : rows){
			RoomResDD roomResDD = new RoomResDD(
					(String) row.get("dateValue"),
					(String) row.get("time"),
					(int) row.get("borrower_borrowerID"),
					(int) row.get("room_roomID")

			);
			roomResDDS.add(roomResDD);
		}
		return new Gson().toJson(roomResDDS);
	}
}


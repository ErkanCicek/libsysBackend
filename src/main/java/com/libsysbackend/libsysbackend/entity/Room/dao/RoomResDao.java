package com.libsysbackend.libsysbackend.entity.Room.dao;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
}


package com.libsysbackend.libsysbackend.entity.Room.service;

import com.libsysbackend.libsysbackend.entity.Room.dao.RoomResDao;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record RoomResService(RoomResDao roomResDetailDao) {

	public List<Integer> getNonAvaliableTimesByRoomIdAndRoomResDateId(Integer roomResId, Integer roomId) {
		return this.roomResDetailDao.getNonAvaliableTimesByRoomIdAndRoomResDateId(roomResId, roomId);
	}

	public Integer getRoomResIdByDate(String dateIn) {
		return this.roomResDetailDao.getRoomResIdByDate(dateIn);
	}

	public void insertIntoRoomResDate(String currDate) {
		this.roomResDetailDao.insertNewDateIntoRoomResDate(currDate);
	}

	public String reserveStudyRoom(Integer roomResId, String time, Integer borrowerId, Integer roomId){
		return this.roomResDetailDao.reserveStudyRoom(roomResId, time, borrowerId, roomId);
	}
}

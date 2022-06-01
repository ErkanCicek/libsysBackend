package com.libsysbackend.libsysbackend.entity.Room.service;

import com.libsysbackend.libsysbackend.entity.Room.dao.RoomDao;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
	private final RoomDao roomDao;

	public RoomService(RoomDao roomDao) {
		this.roomDao = roomDao;
	}

	public String getRoomById(Integer roomid){
		return this.roomDao.getRoomById(roomid);
	}
}

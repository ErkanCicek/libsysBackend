package com.libsysbackend.libsysbackend.entity.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoomService {

	@Autowired
	private RoomDAO roomDAO;

	public String getRoomById(int roomId){
		return roomDAO.getRoomById(roomId);
	}
}

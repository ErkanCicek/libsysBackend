package com.libsysbackend.libsysbackend.entity.Room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "room/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class RoomController {
	@Autowired
	private RoomService roomService;

	@GetMapping("get/roomById")
	public String getRoomById(@RequestParam("roomId")int roomId){
		return roomService.getRoomById(roomId);
	}
}

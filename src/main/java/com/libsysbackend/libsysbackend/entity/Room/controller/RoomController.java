package com.libsysbackend.libsysbackend.entity.Room.controller;

import com.libsysbackend.libsysbackend.entity.Room.service.RoomService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "room/", method = {RequestMethod.GET})
public class RoomController {

	private final RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}


	@GetMapping("get/roomById")
	public String getRoomById(@RequestParam("id") Integer roomid){
		return this.roomService.getRoomById(roomid);
	}
}

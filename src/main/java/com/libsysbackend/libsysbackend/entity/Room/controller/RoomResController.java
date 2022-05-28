package com.libsysbackend.libsysbackend.entity.Room.controller;

import com.libsysbackend.libsysbackend.entity.Room.service.RoomResService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "roomRes/", method = {RequestMethod.GET, RequestMethod.POST}) //for both roomresdate and roomresdetails
public class RoomResController {

	private final RoomResService roomResDetailService;

	public RoomResController(RoomResService roomResDetailService) {
		this.roomResDetailService = roomResDetailService;
	}

	@GetMapping("get/freeTimesByIds")
	public List<Integer> getAvaliableTimesByRoomIdAndRoomResDateId(
			@RequestParam("roomresid")Integer roomresid,
			@RequestParam("roomid") Integer roomid
			){
		return this.roomResDetailService.getNonAvaliableTimesByRoomIdAndRoomResDateId(roomresid, roomid);
	}

	@GetMapping("get/roomResIdByDate")
	public Integer getRoomResIdById(@RequestParam("value")String dateIn){
		return this.roomResDetailService.getRoomResIdByDate(dateIn);
	}

	@PostMapping("post/insertIntoRoomResDate")
	public void insertIntoRoomResDate(@RequestParam("value")String currDate){
		this.roomResDetailService.insertIntoRoomResDate(currDate);
	}

	@PostMapping("post/reserveRoom")
	public String reserveStudyRoom(
			@RequestParam("roomResId") Integer roomResId,
			@RequestParam("time") String time,
			@RequestParam("borrowerId") Integer borrowerId,
			@RequestParam("roomId") Integer roomId
	){
		return this.roomResDetailService.reserveStudyRoom(roomResId, time, borrowerId, roomId);
	}
	@GetMapping("get/getAllReservationsBySSN")
	public String getAllReservationsBySSN(@RequestParam("value")String SSN){
		return this.roomResDetailService.getAllReservationsBySSN(SSN);
	}
}

package com.libsysbackend.libsysbackend.Room;

import com.google.gson.Gson;

import java.util.Arrays;

public class RoomReservation {
	private int roomReservationID;
	private int roomID;
	private String date;
	private int[]timeArray;

	public RoomReservation(int roomReservationID, int roomID, String date, String timeJson) {
		this.roomReservationID = roomReservationID;
		this.roomID = roomID;
		this.date = date;
		this.timeArray = new Gson().fromJson(timeJson, int[].class);
	}


	public int getRoomReservationID() {
		return roomReservationID;
	}

	public void setRoomReservationID(int roomReservationID) {
		this.roomReservationID = roomReservationID;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int[] getTimeArray() {
		return timeArray;
	}

	public void setTimeArray(int[] timeArray) {
		this.timeArray = timeArray;
	}

	@Override
	public String toString() {
		return "RoomReservation{" +
				"roomReservationID=" + roomReservationID +
				", roomID=" + roomID +
				", date='" + date + '\'' +
				", timeArray=" + Arrays.toString(timeArray) +
				'}';
	}
}

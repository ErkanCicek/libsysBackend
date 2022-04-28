package com.libsysbackend.libsysbackend.customerSide.model;

import com.google.gson.Gson;

import java.util.Arrays;

public class RoomReservation {
	private int roomReservationID;
	private int RoomID;
	private String date;
	private int[]timeArray;
	private int borrowerId;

	public RoomReservation(int roomReservationID, int roomID, String date, String timeArray, int borrowerId) {
		Gson gson = new Gson();
		this.roomReservationID = roomReservationID;
		this.RoomID = roomID;
		this.date = date;
		this.timeArray = gson.fromJson(timeArray, int[].class);
		this.borrowerId = borrowerId;
	}

	public int getRoomReservationID() {
		return roomReservationID;
	}

	public void setRoomReservationID(int roomReservationID) {
		this.roomReservationID = roomReservationID;
	}

	public int getRoomID() {
		return RoomID;
	}

	public void setRoomID(int roomID) {
		RoomID = roomID;
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

	public int getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(int borrowerId) {
		this.borrowerId = borrowerId;
	}

	@Override
	public String toString() {
		return "RoomReservation{" +
				"roomReservationID=" + roomReservationID +
				", RoomID=" + RoomID +
				", date='" + date + '\'' +
				", timeArray=" + Arrays.toString(timeArray) +
				", borrowerId=" + borrowerId +
				'}';
	}
}

package com.libsysbackend.libsysbackend.entity.Room;

import com.google.gson.Gson;

import java.util.Arrays;

public class Room {
	private int roomID;
	private String roomName;
	private int[]defultTimeArray;
	private String imageUrl;

	public Room(int roomID, String roomName, String defuaultTimeArray, String imageUrl) {
		Gson gson = new Gson();
		this.roomID = roomID;
		this.roomName = roomName;
		defultTimeArray = gson.fromJson(defuaultTimeArray, int[].class);
		this.imageUrl = imageUrl;
	}

	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int[] getDefultTimeArray() {
		return defultTimeArray;
	}

	public void setDefultTimeArray(int[] defultTimeArray) {
		this.defultTimeArray = defultTimeArray;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	@Override
	public String toString() {
		return "Room{" +
				"roomID=" + roomID +
				", roomName='" + roomName + '\'' +
				", defultTimeArray=" + Arrays.toString(defultTimeArray) +
				", imageUrl='" + imageUrl + '\'' +
				'}';
	}
}

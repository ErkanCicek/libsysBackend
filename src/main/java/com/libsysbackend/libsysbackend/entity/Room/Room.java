package com.libsysbackend.libsysbackend.entity.Room;

import java.util.Arrays;

public class Room {
	private Integer roomId;
	private String roomName;
	private int[]timeArray;
	private String imageUrl;

	public Room(Integer roomId, String roomName, String imageUrl) {
		this.roomId = roomId;
		this.roomName = roomName;
		this.timeArray = new int[]{
				10,12,14,16,18
		};
		this.imageUrl = imageUrl;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	public String getRoomName() {
		return roomName;
	}

	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}

	public int[] getTimeArray() {
		return timeArray;
	}

	public void setTimeArray(int[] timeArray) {
		this.timeArray = timeArray;
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
				"roomId=" + roomId +
				", roomName='" + roomName + '\'' +
				", timeArray=" + Arrays.toString(timeArray) +
				", imageUrl='" + imageUrl + '\'' +
				'}';
	}
}

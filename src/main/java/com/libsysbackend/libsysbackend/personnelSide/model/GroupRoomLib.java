package com.libsysbackend.libsysbackend.personnelSide.model;

public class GroupRoomLib {
	private long roomID;
	private String roomName;
	private String defaultTimeArray;
	private String imageUrl;
	private int roomReservationID;
	private String date;
	
	public GroupRoomLib(long roomID, String roomName, String defaultTimeArray, String imageUrl) {
		this.roomID = roomID;
		this.roomName = roomName;
		this.defaultTimeArray = defaultTimeArray;
		this.imageUrl = imageUrl;
	}
	
	public GroupRoomLib(int roomReservationID, long roomID, String date) {
		this.roomReservationID = roomReservationID;
		this.roomID = roomID;
		this.date = date;
	}
	
	public long getRoomID() {
		return roomID;
	}
	
	public void setRoomID(long roomID) {
		this.roomID = roomID;
	}
	
	public String getRoomName() {
		return roomName;
	}
	
	public void setRoomName(String roomName) {
		this.roomName = roomName;
	}
	
	public String getDefaultTimeArray() {
		return defaultTimeArray;
	}
	
	public void setDefaultTimeArray(String defaultTimeArray) {
		this.defaultTimeArray = defaultTimeArray;
	}
	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	@Override
	public String toString() {
		return "GroupRoomLib{" + "roomID=" + roomID + ", roomName='" + roomName + '\'' + ", defaultTimeArray='" + defaultTimeArray + '\'' + ", imageUrl='" + imageUrl + '\'' + '}';
	}
}

package com.libsysbackend.libsysbackend.entity.Room;

public class RoomResDetail {
	private Integer roomreserverationdetailId;
	private Integer fkRoomReservationDate;
	private Integer time;
	private Integer borrowerId;
	private Integer roomId;

	public RoomResDetail(Integer roomreserverationdetailId, Integer fkRoomReservationDate, Integer time, Integer borrowerId, Integer roomId) {
		this.roomreserverationdetailId = roomreserverationdetailId;
		this.fkRoomReservationDate = fkRoomReservationDate;
		this.time = time;
		this.borrowerId = borrowerId;
		this.roomId = roomId;
	}

	public Integer getRoomreserverationdetailId() {
		return roomreserverationdetailId;
	}

	public void setRoomreserverationdetailId(Integer roomreserverationdetailId) {
		this.roomreserverationdetailId = roomreserverationdetailId;
	}

	public Integer getFkRoomReservationDate() {
		return fkRoomReservationDate;
	}

	public void setFkRoomReservationDate(Integer fkRoomReservationDate) {
		this.fkRoomReservationDate = fkRoomReservationDate;
	}

	public Integer getTime() {
		return time;
	}

	public void setTime(Integer time) {
		this.time = time;
	}

	public Integer getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Integer borrowerId) {
		this.borrowerId = borrowerId;
	}

	public Integer getRoomId() {
		return roomId;
	}

	public void setRoomId(Integer roomId) {
		this.roomId = roomId;
	}

	@Override
	public String toString() {
		return "RoomResDetail{" +
				"roomreserverationdetailId=" + roomreserverationdetailId +
				", fkRoomReservationDate=" + fkRoomReservationDate +
				", time=" + time +
				", borrowerId=" + borrowerId +
				", roomId=" + roomId +
				'}';
	}
}

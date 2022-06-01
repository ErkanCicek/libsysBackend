package com.libsysbackend.libsysbackend.entity.Room;

public class RoomResDate {
	private Integer idRoomReservationDate;
	private String dateValue;

	public RoomResDate(Integer idRoomReservationDate, String dateValue) {
		this.idRoomReservationDate = idRoomReservationDate;
		this.dateValue = dateValue;
	}

	public Integer getIdRoomReservationDate() {
		return idRoomReservationDate;
	}

	public void setIdRoomReservationDate(Integer idRoomReservationDate) {
		this.idRoomReservationDate = idRoomReservationDate;
	}

	public String getDateValue() {
		return dateValue;
	}

	public void setDateValue(String dateValue) {
		this.dateValue = dateValue;
	}
}

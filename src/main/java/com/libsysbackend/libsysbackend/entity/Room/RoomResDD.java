package com.libsysbackend.libsysbackend.entity.Room;

public class RoomResDD {
    private Integer idRoomReservationDate;
    private String dateValue;
    private Integer roomreserverationdetailId;
    private Integer fkRoomReservationDate;
    private String time;
    private Integer borrowerId;
    private Integer roomId;

    public RoomResDD(String dateValue, String time, Integer borrowerId, Integer roomId) {
        this.dateValue = dateValue;
        this.time = time;
        this.borrowerId = borrowerId;
        this.roomId = roomId;
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

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
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
        return "RoomResDD{" +
                "idRoomReservationDate=" + idRoomReservationDate +
                ", dateValue='" + dateValue + '\'' +
                ", roomreserverationdetailId=" + roomreserverationdetailId +
                ", fkRoomReservationDate=" + fkRoomReservationDate +
                ", time='" + time + '\'' +
                ", borrowerId=" + borrowerId +
                ", roomId=" + roomId +
                '}';
    }
}

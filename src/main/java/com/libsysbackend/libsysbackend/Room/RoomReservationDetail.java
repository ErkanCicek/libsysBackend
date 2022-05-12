package com.libsysbackend.libsysbackend.Room;

public class RoomReservationDetail {
    private int idroomreservationdetail;
    private String time;
    private int borrower_borrowerID;
    private int roomreservationId;

    public RoomReservationDetail(int idroomreservationdetail, String time, int borrower_borrowerID, int roomreservationId){
        this.idroomreservationdetail = idroomreservationdetail;
        this.time = time;
        this.borrower_borrowerID = borrower_borrowerID;
        this.roomreservationId = roomreservationId;

    }

    public int getIdroomreservationdetail() {return idroomreservationdetail;}

    public void setIdroomreservationdetail(int idroomreservationdetail) { this.idroomreservationdetail = idroomreservationdetail;}

    public String getTime() {return time;}

    public void setTime(String time) { this.time = time;}

    public int getBorrower_borrowerID() { return borrower_borrowerID;}

    public void setBorrower_borrowerID(int borrower_borrowerID) { this.borrower_borrowerID = borrower_borrowerID;}

    public int getRoomreservationId() { return roomreservationId;}

    public void setRoomreservationId(int roomreservationId) { this.roomreservationId = roomreservationId;}

    @Override
    public String toString(){
        return "RoomReservationDetail{" +
                "idroomreservationdetail" +
                "time" +  '\'' +
                "borrower_borrowerID" +
                "roomreservationId" +
                "}";



    }



























}

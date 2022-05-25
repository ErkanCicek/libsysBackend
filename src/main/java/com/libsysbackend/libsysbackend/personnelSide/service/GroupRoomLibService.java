package com.libsysbackend.libsysbackend.personnelSide.service;

import com.libsysbackend.libsysbackend.personnelSide.dao.GroupRoomLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.GroupRoomLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.net.URLDecoder;
import java.util.ArrayList;

@Repository
@Service
public class GroupRoomLibService {
	
	@Autowired
	GroupRoomLibDao groupRoomLibDao;
	
	public ArrayList<GroupRoomLib> getAllGroupRoomBookings(){
		return (ArrayList<GroupRoomLib>) groupRoomLibDao.getAllGroupRoomBookings();}
	
	public void addGroupRoom(String groupRoomName){groupRoomLibDao.addGroupRoom(URLDecoder.decode(groupRoomName));}
	
	public String deleteGroupRoomByID(String groupRoomID){return groupRoomLibDao.deleteGroupRoomByID(String.valueOf(groupRoomID));}
	
	public GroupRoomLib getGroupRoomByID(String roomID){return groupRoomLibDao.getGroupRoomByID(String.valueOf(roomID));}
	
	public String deleteGroupRoomBookingByID(String roomResID){return groupRoomLibDao.deleteGroupRoomBookingByID(String.valueOf(roomResID));}
	
	public GroupRoomLib getGroupRoomBookingByID(String roomResID){return groupRoomLibDao.getGroupRoomBookingByID(String.valueOf(roomResID));}
	
	public void bookGroupRoom(String groupRoomID, String bookingDate, String borrowerID){
		groupRoomLibDao.bookGroupRoom(URLDecoder.decode(groupRoomID), URLDecoder.decode(bookingDate),
				URLDecoder.decode(borrowerID));}
}

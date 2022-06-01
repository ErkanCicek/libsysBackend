package com.libsysbackend.libsysbackend.personnelSide.dao;

import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.GroupRoomLib;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Repository;

import java.nio.file.attribute.GroupPrincipal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class GroupRoomLibDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public List<GroupRoomLib> getAllGroupRoomBookings() {
		String query = "SELECT * FROM roomreservation";
		
		List<Map<String, Object>> rows = jdbcTemplate.queryForList(query);
		List<GroupRoomLib> groupRoomBookingsList = new ArrayList<>();
		
		for (Map<String, Object> row : rows) {
			GroupRoomLib groupRoomLib =
					new GroupRoomLib(Integer.parseInt(row.get("roomReservationID").toString()),
							(int) row.get("roomID"),
							(String) row.get("date"));
			groupRoomBookingsList.add(groupRoomLib);
		}
		return groupRoomBookingsList;
	}
	
	public void addGroupRoom(String groupRoomName)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String groupRoomNameSpaceFixed = groupRoomName.replace("WHITESPACEHEREX", " ");
		
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("add_groupRoom");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("groupRoomName", groupRoomNameSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		simpleJdbcCall.execute(in);
	}
	
	public String deleteGroupRoomByID(String groupRoomID) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_groupRoom");
		Integer groupRoomIDToInt = Integer.parseInt(groupRoomID);
		String returnable = String.valueOf(simpleJdbcCall.execute(groupRoomIDToInt));
		
		return returnable;
	}
	
	public GroupRoomLib getGroupRoomByID(String roomID) {
		String query = "SELECT * FROM room WHERE roomID = ? LIMIT 1";
		
		GroupRoomLib groupRoomLib = jdbcTemplate.queryForObject(query, new RowMapper<GroupRoomLib>() {
			@Override
			public GroupRoomLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				GroupRoomLib groupRoomLib = new GroupRoomLib(rs.getInt("roomID"),
						rs.getString("roomName"),
						rs.getString("defaultTimeArray"),
						rs.getString("imageUrl"));
				
				return groupRoomLib;
			}
		}, roomID);
		
		return groupRoomLib;
	}
	
	public String deleteGroupRoomBookingByID(String roomResID) {
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("delete_groupRoomBooking");
		Integer roomResIDToInt = Integer.parseInt(roomResID);
		String returnable = String.valueOf(simpleJdbcCall.execute(roomResIDToInt));
		
		return returnable;
	}
	
	public GroupRoomLib getGroupRoomBookingByID(String roomResID) {
		String query = "SELECT * FROM roomreservation WHERE roomReservationID = ? LIMIT 1";
		
		GroupRoomLib groupRoomLib = jdbcTemplate.queryForObject(query, new RowMapper<GroupRoomLib>() {
			@Override
			public GroupRoomLib mapRow(ResultSet rs, int rowNum) throws SQLException {
				GroupRoomLib groupRoomLib = new GroupRoomLib(rs.getInt("roomReservationID"),
						rs.getLong("roomID"),
						rs.getString("date"));
				
				return groupRoomLib;
			}
		}, roomResID);
		
		return groupRoomLib;
	}
	
	public String bookGroupRoom(String groupRoomID, String bookingDate, String borrowerID)
	{
		// If a space (" ") was added from frontend it will be replaced by the phrase "WHITESPACEHEREX".
		// This phrase is raplaced back with a space here so that the String takes its original form with spaces included
		// (This was done to fix an annoying bug where the program simply refused to take in spaces in Strings...)
		String groupRoomIDSpaceFixed = groupRoomID.replace("WHITESPACEHEREX", " ");
		String bookingDateSpaceFixed = bookingDate.replace("WHITESPACEHEREX", " ");
		String borrowerIDSpaceFixed = borrowerID.replace("WHITESPACEHEREX", " ");
		
		SimpleJdbcCall simpleJdbcCall = new SimpleJdbcCall(jdbcTemplate).withProcedureName("book_groupRoom");
		
		Map<String, String> inParameters = new HashMap<>();
		
		inParameters.put("groupRoomID", groupRoomIDSpaceFixed);
		inParameters.put("bookingDate", bookingDateSpaceFixed);
		inParameters.put("borrowerID", borrowerIDSpaceFixed);
		
		SqlParameterSource in = new MapSqlParameterSource(inParameters);
		
		String returnable = String.valueOf(simpleJdbcCall.execute(in));
		
		return returnable;
	}
}

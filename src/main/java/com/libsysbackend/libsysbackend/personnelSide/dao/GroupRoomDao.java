package com.libsysbackend.libsysbackend.personnelSide.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class GroupRoomDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	
}

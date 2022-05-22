package com.libsysbackend.libsysbackend.personnelSide.service;

import com.libsysbackend.libsysbackend.personnelSide.dao.GroupRoomDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
@Service
public class GroupRoomService {
	
	@Autowired
	GroupRoomDao groupRoomDao;
}

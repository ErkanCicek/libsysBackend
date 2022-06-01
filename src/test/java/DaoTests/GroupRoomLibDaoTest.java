package DaoTests;

import com.libsysbackend.libsysbackend.personnelSide.dao.GroupRoomLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.GroupRoomLib;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GroupRoomLibDaoTest {
	
	@Mock
	JdbcTemplate jdbcTemplateMock;
	
	@Mock
	GroupRoomLibDao groupRoomLibDaoMock;
	
	@Mock
	List<GroupRoomLib> groupRoomLibListMock = new ArrayList<>();
	
	@Mock
	GroupRoomLib groupRoomLibMock = new GroupRoomLib(1, "Ett rum", "Hmm", "jpg");
	
	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this);} // Injecta mocken från denna klass
	
	@Test
	void getAllGroupRoomBookings() {
		// Setup
		Mockito.when(groupRoomLibDaoMock.getAllGroupRoomBookings()).thenReturn(groupRoomLibListMock);
		
		// Action
		List<GroupRoomLib> testList = groupRoomLibDaoMock.getAllGroupRoomBookings();
		
		// Result
		assertEquals(groupRoomLibListMock, testList);
	}
	
	@Test
	void addGroupRoom() {
		// Setup
		String query = "INSERT INTO room(roomName, defaultTimeArray, imageUrl) VALUES (?, ?, ?)";
		Mockito.when(jdbcTemplateMock.update(query,"Ett rum", "Hmm", "jpg")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, "Ett rum", "Hmm", "jpg");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,"Ett rum", "Hmm", "jpg");
	}
	
	@Test
	void deleteGroupRoomByID() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(groupRoomLibDaoMock.deleteGroupRoomByID("01")).thenReturn(works);
		
		// Action
		String fakeResult = groupRoomLibDaoMock.deleteGroupRoomByID("01");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void getGroupRoomByID() {
		// Setup
		Mockito.when(groupRoomLibDaoMock.getGroupRoomByID(Mockito.anyString())).thenReturn(groupRoomLibMock);
		
		// Action
		GroupRoomLib e = groupRoomLibDaoMock.getGroupRoomByID("1");
		
		// Result
		assertEquals(groupRoomLibMock, e);
		Mockito.verify(groupRoomLibDaoMock).getGroupRoomByID("1");
	}
	
	@Test
	void deleteGroupRoomBookingByID() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(groupRoomLibDaoMock.deleteGroupRoomBookingByID("01")).thenReturn(works);
		
		// Action
		String fakeResult = groupRoomLibDaoMock.deleteGroupRoomBookingByID("01");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void getGroupRoomBookingByID() {
		// Setup
		Mockito.when(groupRoomLibDaoMock.getGroupRoomBookingByID(Mockito.anyString())).thenReturn(groupRoomLibMock);
		
		// Action
		GroupRoomLib e = groupRoomLibDaoMock.getGroupRoomBookingByID("1");
		
		// Result
		assertEquals(groupRoomLibMock, e);
		Mockito.verify(groupRoomLibDaoMock).getGroupRoomBookingByID("1");
	}
	
	@Test
	void bookGroupRoom() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(groupRoomLibDaoMock.bookGroupRoom("1", "2day", "1")).thenReturn(works);
		
		// Action
		String fakeResult = groupRoomLibDaoMock.bookGroupRoom("1", "2day", "1");
		
		// Result
		assertEquals(works, fakeResult);
	}
}
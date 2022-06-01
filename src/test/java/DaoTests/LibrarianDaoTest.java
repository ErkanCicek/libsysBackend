package DaoTests;

import com.libsysbackend.libsysbackend.personnelSide.dao.GroupRoomLibDao;
import com.libsysbackend.libsysbackend.personnelSide.dao.LibrarianDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
import com.libsysbackend.libsysbackend.personnelSide.model.GroupRoomLib;
import com.libsysbackend.libsysbackend.personnelSide.model.Librarian;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianDaoTest {
	
	
	@Mock
	JdbcTemplate jdbcTemplateMock;
	
	@Mock
	LibrarianDao librarianDaoMock;
	
	@Mock
	List<Librarian> librarianListMock = new ArrayList<>();
	
	@Mock
	Librarian librarianMock = new Librarian(1, "Patrik", "Testar", "931029-1234", "admin");
	
	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this);} // Injecta mocken från denna klass
	
	@Test
	void getAllPersonel() {
		// Setup
		Mockito.when(librarianDaoMock.getAllPersonel()).thenReturn(librarianListMock);
		
		// Action
		List<Librarian> testList = librarianDaoMock.getAllPersonel();
		
		// Result
		assertEquals(librarianListMock, testList);
	}
	
	@Test
	void addPersonel() {
		// Setup
		String query = "INSERT INTO personel(name, lastName, SSN, ROLE) VALUES (?, ?, ?, ?)";
		Mockito.when(jdbcTemplateMock.update(query,"Patrik", "Testar", "931029-1234", "admin")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, "Patrik", "Testar", "931029-1234", "admin");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,"Patrik", "Testar", "931029-1234", "admin");
	}
	
	@Test
	void addPersonelCredentials() {
		// Setup
		String query = "INSERT INTO personel(personelID, password) VALUES (?, ?)";
		Mockito.when(jdbcTemplateMock.update(query,1, "hemligt")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, 1, "hemligt");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,1, "hemligt");
	}
	
	@Test
	void deletePersonelByID() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(librarianDaoMock.deletePersonelByID("01")).thenReturn(works);
		
		// Action
		String fakeResult = librarianDaoMock.deletePersonelByID("01");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void getPersonelById() {
		// Setup
		Mockito.when(librarianDaoMock.getPersonelById(Mockito.anyString())).thenReturn(librarianMock);
		
		// Action
		Librarian e = librarianDaoMock.getPersonelById("1");
		
		// Result
		assertEquals(librarianMock, e);
		Mockito.verify(librarianDaoMock).getPersonelById("1");
	}
	
	@Test
	void libLogin() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(librarianDaoMock.libLogin("1", "hemligt")).thenReturn(works);
		
		// Action
		String fakeResult = librarianDaoMock.libLogin("1", "hemligt");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void getRoleById() {
		// Setup
		Mockito.when(librarianDaoMock.getRoleById(Mockito.anyString())).thenReturn(librarianMock);
		
		// Action
		Librarian e = librarianDaoMock.getRoleById("1");
		
		// Result
		assertEquals(librarianMock, e);
		Mockito.verify(librarianDaoMock).getRoleById("1");
	}
}
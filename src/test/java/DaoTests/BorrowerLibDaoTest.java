package DaoTests;

import com.libsysbackend.libsysbackend.personnelSide.dao.BorrowedBooksLibDao;
import com.libsysbackend.libsysbackend.personnelSide.dao.BorrowerLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowerLib;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BorrowerLibDaoTest {
	
	@Mock
	JdbcTemplate jdbcTemplateMock;
	
	@Mock
	BorrowerLibDao borrowerLibDaoMock;
	
	@Mock
	List<BorrowerLib> borrowerLibListMock = new ArrayList<>();
	
	@Mock
	BorrowerLib borrowerLibMock = new BorrowerLib(1, "Patrik", "Testar", "931029-1234");
	
	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this);} // Injecta mocken från denna klass
	
	@Test
	void getAllBorrowers() {
		// Setup
		Mockito.when(borrowerLibDaoMock.getAllBorrowers()).thenReturn(borrowerLibListMock);
		
		// Action
		List<BorrowerLib> testList = borrowerLibDaoMock.getAllBorrowers();
		
		// Result
		assertEquals(borrowerLibListMock, testList);
	}
	
	@Test
	void getBorrowerByBorrowerID() {
		// Setup
		Mockito.when(borrowerLibDaoMock.getBorrowerByBorrowerID(Mockito.anyString())).thenReturn(borrowerLibMock);
		
		// Action
		BorrowerLib e = borrowerLibDaoMock.getBorrowerByBorrowerID("1");
		
		// Result
		assertEquals(borrowerLibMock, e);
		Mockito.verify(borrowerLibDaoMock).getBorrowerByBorrowerID("1");
	}
	
	@Test
	void deleteBorrowerByID() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(borrowerLibDaoMock.deleteBorrowerByID("01")).thenReturn(works);
		
		// Action
		String fakeResult = borrowerLibDaoMock.deleteBorrowerByID("01");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void addBorrower() {
		// Setup
		String query = "INSERT INTO borrower(name, lastName, SSN, role) VALUES (?, ?, ?, ?)";
		Mockito.when(jdbcTemplateMock.update(query,"Patrik", "Testar", "931029-1234", "bibliotekarie")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, "Patrik", "Testar", "931029-1234", "bibliotekarie");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,"Patrik", "Testar", "931029-1234", "bibliotekarie");
	}
	
	@Test
	void addBorrowerCredentials() {
		// Setup
		String query = "INSERT INTO borrowercredentials(borrowerPassWord, borrower_BorrowerID) VALUES (?, ?)";
		Mockito.when(jdbcTemplateMock.update(query,"hemligt", "1")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, "hemligt", "1");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,"hemligt", "1");
	
	}
}
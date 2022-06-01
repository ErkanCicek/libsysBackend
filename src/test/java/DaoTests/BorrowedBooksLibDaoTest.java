package DaoTests;

import com.libsysbackend.libsysbackend.personnelSide.dao.BorrowedBooksLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BorrowedBooksLibDaoTest {
	
	@Mock
	JdbcTemplate jdbcTemplateMock;
	
	@Mock
	BorrowedBooksLibDao borrowedBooksLibDaoMock;
	
	@Mock
	List<BorrowedBooksLib> borrowedBooksLibListMock = new ArrayList<>();
	
	@Mock
	BorrowedBooksLib borrowedBooksLibMock = new BorrowedBooksLib(1, "2 weeks", "931029-1234", 1, "1234567891023-2");
	
	@BeforeEach
	void setup(){
		MockitoAnnotations.openMocks(this);} // Injecta mocken från denna klass
	
	@Test
	void getAllBorrowedBooks() {
		// Setup
		Mockito.when(borrowedBooksLibDaoMock.getAllBorrowedBooks()).thenReturn(borrowedBooksLibListMock);
		
		// Action
		List<BorrowedBooksLib> testList = borrowedBooksLibDaoMock.getAllBorrowedBooks();
		
		// Result
		assertEquals(borrowedBooksLibListMock, testList);
		
	}
	
	@Test
	void loanBook() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(borrowedBooksLibDaoMock.loanBook("931029-1234", "1234567891023")).thenReturn(works);
		
		// Action
		String fakeResult = borrowedBooksLibDaoMock.loanBook("931029-1234", "1234567891023");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void returnBookByISBN() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(borrowedBooksLibDaoMock.returnBookByISBN("1234567891023-2")).thenReturn(works);
		
		// Action
		String fakeResult = borrowedBooksLibDaoMock.returnBookByISBN("1234567891023-2");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void getBorrowedBookByISBN() {
		// Setup
		Mockito.when(borrowedBooksLibDaoMock.getBorrowedBookByISBN(Mockito.anyString())).thenReturn(borrowedBooksLibMock);
		
		// Action
		BorrowedBooksLib e = borrowedBooksLibDaoMock.getBorrowedBookByISBN("1234567891023-2");
		
		// Result
		assertEquals(borrowedBooksLibMock, e);
		Mockito.verify(borrowedBooksLibDaoMock).getBorrowedBookByISBN("1234567891023-2");
	}
}
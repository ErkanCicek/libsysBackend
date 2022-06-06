package DaoTests;

import com.libsysbackend.libsysbackend.personnelSide.dao.BookLibDao;
import com.libsysbackend.libsysbackend.personnelSide.model.BookLib;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.jdbc.core.JdbcTemplate;

import static org.junit.jupiter.api.Assertions.*;

class BookLibDaoTest {
	
	@Mock
	JdbcTemplate jdbcTemplateMock;
	
	@Mock
	BookLibDao bookLibDaoMock;
	
	@Mock
	BookLib bookLibMock = new BookLib(1, "1234", "Testbok", "Bör fungera", "1", "1", "1");
	
	@BeforeEach
	void setup(){MockitoAnnotations.openMocks(this);} // Injecta mocken från denna klass
	
	@Test
	void getBookByISBN() {
		// Setup
		Mockito.when(bookLibDaoMock.getBookByISBN(Mockito.anyString())).thenReturn(bookLibMock);
		
		// Action
		BookLib e = bookLibDaoMock.getBookByISBN("1");
		
		// Result
		assertEquals(bookLibMock, e);
		Mockito.verify(bookLibDaoMock).getBookByISBN("1");
	}
	
	@Test
	void getBookByTitle() {
		// Setup
		Mockito.when(bookLibDaoMock.getBookByTitle(Mockito.anyString())).thenReturn(bookLibMock);
		
		// Action
		BookLib e = bookLibDaoMock.getBookByTitle("Testbok");
		
		// Result
		assertEquals(bookLibMock, e);
		Mockito.verify(bookLibDaoMock).getBookByTitle("Testbok");
	}
	
	@Test
	void getBookByAuthorName() {
		// Setup
		Mockito.when(bookLibDaoMock.getBookByAuthorName(Mockito.anyString())).thenReturn(bookLibMock);
		
		// Action
		BookLib e = bookLibDaoMock.getBookByAuthorName("Testförfattare");
		
		// Result
		assertEquals(bookLibMock, e);
		Mockito.verify(bookLibDaoMock).getBookByAuthorName("Testförfattare");
	}
	
	@Test
	void getBookByGenreName() {
		// Setup
		Mockito.when(bookLibDaoMock.getBookByGenreName(Mockito.anyString())).thenReturn(bookLibMock);
		
		// Action
		BookLib e = bookLibDaoMock.getBookByGenreName("Testkategori");
		
		// Result
		assertEquals(bookLibMock, e);
		Mockito.verify(bookLibDaoMock).getBookByGenreName("Testkategori");
	}
	
	@Test
	void deleteBookByID() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(bookLibDaoMock.deleteBookByID("01")).thenReturn(works);
		
		// Action
		String fakeResult = bookLibDaoMock.deleteBookByID("01");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void addBook() {
		// Setup
		String query = "INSERT INTO book(ISBN, title, bookDesc, authorID, genreID, isBookAvailable) VALUES (?, ?, ?, " +
				"?, ?, ?)";
		Mockito.when(jdbcTemplateMock.update(query,"1234", "Testbok", "Bör fungera", "1", "1", "1")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, "1234", "Testbok", "Bör fungera", "1", "1", "1");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,"1234", "Testbok", "Bör fungera", "1", "1", "1");
	}
	
	@Test
	void addAuthor() {
		// Setup
		String query = "INSERT INTO author(authorName) VALUES (?)";
		Mockito.when(jdbcTemplateMock.update(query,"Testförfattare")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, "Testförfattare");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,"Testförfattare");
	}
	
	@Test
	void deleteAuthorByID() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(bookLibDaoMock.deleteAuthorByID("01")).thenReturn(works);
		
		// Action
		String fakeResult = bookLibDaoMock.deleteAuthorByID("01");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void addGenre() {
		// Setup
		String query = "INSERT INTO genre(genreName, genreDesc) VALUES (?, ?)";
		Mockito.when(jdbcTemplateMock.update(query,"Testkategori", "Fungera det bör")).thenReturn(1);
		
		// Action
		int i = jdbcTemplateMock.update(query, "Testkategori", "Fungera det bör");
		
		// Result
		assertEquals(1, i);
		Mockito.verify(jdbcTemplateMock).update(query,"Testkategori", "Fungera det bör");
	}
	
	@Test
	void deleteGenreByID() {
		// Setup
		String works = "works"; // String I want returned from delete_saloon
		Mockito.when(bookLibDaoMock.deleteGenreByID("01")).thenReturn(works);
		
		// Action
		String fakeResult = bookLibDaoMock.deleteGenreByID("01");
		
		// Result
		assertEquals(works, fakeResult);
	}
	
	@Test
	void getIsBookAvailable() {
		// Setup
		Mockito.when(bookLibDaoMock.getIsBookAvailable(Mockito.anyString())).thenReturn(bookLibMock);
		
		// Action
		BookLib e = bookLibDaoMock.getIsBookAvailable("1");
		
		// Result
		assertEquals(bookLibMock, e);
		Mockito.verify(bookLibDaoMock).getIsBookAvailable("1");
	}
}
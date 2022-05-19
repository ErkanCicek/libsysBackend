package com.libsysbackend.libsysbackend;

import com.libsysbackend.libsysbackend.personnelSide.service.BookLibService;
import com.libsysbackend.libsysbackend.personnelSide.service.BorrowerLibService;
import com.libsysbackend.libsysbackend.personnelSide.service.LibrarianService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@SpringBootApplication
@RestController
public class LibsysBackendApplication {
	
	public static ApplicationContext context;
	
	@Autowired
	LibrarianService librarianService;
	@Autowired
	BookLibService bookLibService;
	@Autowired
	BorrowerLibService borrowerLibService;
	
	public static void main(String[] args) {
		context = SpringApplication.run(LibsysBackendApplication.class, args);
	}
	
	@GetMapping ("/getLibrarianByID")
	public String getStaffById(@RequestParam (value = "personelID", defaultValue = "incorrect input") String personelID){
		LibrarianService librarianService = context.getBean(LibrarianService.class);
		personelID = String.valueOf(librarianService.getLibrarianByID(Integer.parseInt(personelID)));
		return personelID;
	}
	
	@RequestMapping ("/add_personel")
	public void addPersonel(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		librarianService.addPersonel(separatedValues[1], separatedValues[2], separatedValues[3], separatedValues[4]
				, separatedValues[5], separatedValues[6]);
	}
	
	@RequestMapping ("/add_personelCredentials")
	public void addPersonelCredentials(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		librarianService.addPersonelCredentials(separatedValues[1], separatedValues[2]);
	}
	
	@GetMapping ("/getAllPersonel")
	public String getAllPersonel(){
		LibrarianService librarianService = context.getBean(LibrarianService.class);
		ArrayList allPersonel = librarianService.getAllPersonel();
		
		ArrayList<String> allPersonelString = new ArrayList<>();
		
		for (int i = 0; i < allPersonel.size(); i++){
			allPersonelString.add(allPersonel.get(i).toString());
		}
		
		String returnable = allPersonel.toString();
		
		System.out.println("TEST\n" + returnable);
		return returnable;
	}
	
	@DeleteMapping ("/deletePersonelByID")
	public void deletePersonelById(@RequestParam(value = "personelID", defaultValue = "incorrect input") String personelID) {
		librarianService.deletePersonelByID(personelID);
	}
	
	@GetMapping ("/getRoleByID")
	public String getRoleById(@RequestParam (value = "personelID", defaultValue = "incorrect input") String personelID){
		LibrarianService librarianService = context.getBean(LibrarianService.class);
		personelID = String.valueOf(librarianService.getRoleByID(Integer.parseInt(personelID)));
		return personelID;
	}
	
	@GetMapping ("/getBookByISBN")
	public String getBookByISBN(@RequestParam (value = "ISBN", defaultValue = "incorrect input") String ISBN){
		BookLibService bookService = context.getBean(BookLibService.class);
		ISBN = String.valueOf(bookService.getBookByISBN(ISBN));
		return ISBN;
	}
	
	@GetMapping ("/getBookByTitle")
	public String getBookByTitle(@RequestParam (value = "title", defaultValue = "incorrect input") String title){
		BookLibService bookService = context.getBean(BookLibService.class);
		title = String.valueOf(bookService.getBookByTitle(title));
		return title;
	}
	
	@GetMapping ("/getBookByAuthorID")
	public String getBookByAuthorID(@RequestParam (value = "authorID", defaultValue = "incorrect input") String authorID){
		BookLibService bookService = context.getBean(BookLibService.class);
		authorID = String.valueOf(bookService.getBookByAuthorID(authorID));
		return authorID;
	}
	
	@GetMapping ("/getBookByGenreID")
	public String getBookByGenreID(@RequestParam (value = "genreID", defaultValue = "incorrect input") String genreID){
		BookLibService bookService = context.getBean(BookLibService.class);
		genreID = String.valueOf(bookService.getBookByGenreID(genreID));
		return genreID;
	}
	
	@RequestMapping("/getLastValidationNumber")
	public String getValidationNumber(){
		String returnable = librarianService.getValidationNumber();
		
		return returnable;
	}
	
	@RequestMapping ("/login_verification")
	public void customerLogin(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		librarianService.libLogin(separatedValues[1], separatedValues[2]);
	}
	
	@DeleteMapping ("/deleteBookByID")
	public void deleteBookById(@RequestParam(value = "bookID", defaultValue = "incorrect input") String bookID) {
		bookLibService.deleteBookByID(bookID);
	}
	
	@RequestMapping ("/add_book")
	public void addBook(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		bookLibService.addBook(separatedValues[1], separatedValues[2], separatedValues[3], separatedValues[4],
				separatedValues[5], separatedValues[6]);
	}
	
	@RequestMapping ("/add_author")
	public void addAuthor(@RequestParam(value = "authorName", defaultValue = "incorrect input") String authorName){
		
		bookLibService.addAuthor(authorName);
	}
	
	@DeleteMapping ("/deleteAuthorByID")
	public void deleteAuthorById(@RequestParam(value = "authorID", defaultValue = "incorrect input") String authorID) {
		bookLibService.deleteAuthorByID(authorID);
	}
	
	@RequestMapping ("/add_genre")
	public void addGenre(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		bookLibService.addGenre(separatedValues[1], separatedValues[2]);
	}
	
	@DeleteMapping ("/deleteGenreByID")
	public void deleteGenreById(@RequestParam(value = "genreID", defaultValue = "incorrect input") String genreID) {
		bookLibService.deleteGenreByID(genreID);
	}
	
	@GetMapping ("/getAllBorrowers")
	public String getAllBorrowers(){
		BorrowerLibService borrowerLibService = context.getBean(BorrowerLibService.class);
		ArrayList allBorrowers = borrowerLibService.getAllBorrowers();
		
		ArrayList<String> allBorrowersString = new ArrayList<>();
		
		for (int i = 0; i < allBorrowers.size(); i++){
			allBorrowersString.add(allBorrowers.get(i).toString());
		}
		
		String returnable = allBorrowers.toString();
		
		System.out.println("TEST\n" + returnable);
		return returnable;
	}
	
	@GetMapping ("/getBorrowerByBorrowerID")
	public String getBorrowerByBorrowerID(@RequestParam (value = "borrowerID", defaultValue = "incorrect input") String borrowerID){
		BorrowerLibService bookService = context.getBean(BorrowerLibService.class);
		borrowerID = String.valueOf(borrowerLibService.getBorrowerByBorrowerID(borrowerID));
		return borrowerID;
	}
	
	@DeleteMapping ("/deleteBorrowerByID")
	public void deleteBorrowerById(@RequestParam(value = "borrowerID", defaultValue = "incorrect input") String borrowerID) {
		borrowerLibService.deleteBorrowerByID(borrowerID);
	}
	
	@RequestMapping ("/add_borrower")
	public void addBorrower(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		borrowerLibService.addBorrower(separatedValues[1], separatedValues[2], separatedValues[3], separatedValues[4]
				, separatedValues[5]);
	}
	
	@RequestMapping ("/add_borrowerCredentials")
	public void addBorrowerCredentials(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		borrowerLibService.addBorrowerCredentials(separatedValues[1], separatedValues[2]);
	}
}

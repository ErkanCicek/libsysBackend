package com.libsysbackend.libsysbackend;

import com.libsysbackend.libsysbackend.personnelSide.model.BorrowedBooksLib;
import com.libsysbackend.libsysbackend.personnelSide.model.GroupRoomLib;
import com.libsysbackend.libsysbackend.personnelSide.service.*;
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
	@Autowired
	BorrowedBooksLibService borrowedBooksLibService;
	@Autowired
	GroupRoomLibService groupRoomLibService;
	
	public static void main(String[] args) {
		context = SpringApplication.run(LibsysBackendApplication.class, args);
	}
	
	@GetMapping ("/getLibrarianByID")
	public String getStaffById(@RequestParam (value = "personelID", defaultValue = "incorrect input") String personelID){
		librarianService = context.getBean(LibrarianService.class);
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
		librarianService = context.getBean(LibrarianService.class);
		ArrayList allPersonel = librarianService.getAllPersonel();
		
		ArrayList<String> allPersonelString = new ArrayList<>();
		
		for (int i = 0; i < allPersonel.size(); i++){
			allPersonelString.add(allPersonel.get(i).toString());
		}
		
		String returnable = allPersonel.toString();
		
		return returnable;
	}
	
	@DeleteMapping ("/deletePersonelByID")
	public void deletePersonelById(@RequestParam(value = "personelID", defaultValue = "incorrect input") String personelID) {
		librarianService.deletePersonelByID(personelID);
	}
	
	@GetMapping ("/getRoleByID")
	public String getRoleById(@RequestParam (value = "personelID", defaultValue = "incorrect input") String personelID){
		librarianService = context.getBean(LibrarianService.class);
		personelID = String.valueOf(librarianService.getRoleByID(Integer.parseInt(personelID)));
		return personelID;
	}
	
	@GetMapping ("/getBookByISBN")
	public String getBookByISBN(@RequestParam (value = "ISBN", defaultValue = "incorrect input") String ISBN){
		bookLibService = context.getBean(BookLibService.class);
		ISBN = String.valueOf(bookLibService.getBookByISBN(ISBN));
		return ISBN;
	}
	
	@GetMapping ("/getBookByTitle")
	public String getBookByTitle(@RequestParam (value = "title", defaultValue = "incorrect input") String title){
		bookLibService = context.getBean(BookLibService.class);
		title = String.valueOf(bookLibService.getBookByTitle(title));
		return title;
	}
	
	@GetMapping("/getBookByAuthorName")
	public String getBookByAuthorName(@RequestParam (value = "authorName", defaultValue = "incorrect input") String authorName){
		bookLibService = context.getBean(BookLibService.class);
		authorName = String.valueOf(bookLibService.getBookByAuthorName(authorName));
		return authorName;
	}
	
	@GetMapping("/getBookByGenreName")
	public String getBookByGenreName(@RequestParam (value = "genreName", defaultValue = "incorrect input") String genreName){
		bookLibService = context.getBean(BookLibService.class);
		genreName = String.valueOf(bookLibService.getBookByGenreName(genreName));
		return genreName;
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
				separatedValues[5]);
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
		borrowerLibService = context.getBean(BorrowerLibService.class);
		ArrayList allBorrowers = borrowerLibService.getAllBorrowers();
		
		ArrayList<String> allBorrowersString = new ArrayList<>();
		
		for (int i = 0; i < allBorrowers.size(); i++){
			allBorrowersString.add(allBorrowers.get(i).toString());
		}
		
		String returnable = allBorrowers.toString();
		
		return returnable;
	}
	
	@GetMapping ("/getBorrowerByBorrowerID")
	public String getBorrowerByBorrowerID(@RequestParam (value = "borrowerID", defaultValue = "incorrect input") String borrowerID){
		borrowerLibService = context.getBean(BorrowerLibService.class);
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
	
	@RequestMapping ("/loan_book")
	public void loanBook(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		borrowedBooksLibService.loanBook(separatedValues[1], separatedValues[2]);
	}
	
	@GetMapping ("/getAllBorrowedBooks")
	public String getAllBorrowedBooks(){
		borrowedBooksLibService = context.getBean(BorrowedBooksLibService.class);
		ArrayList allBorrowedBooks = borrowedBooksLibService.getAllBorrowedBooks();
		
		ArrayList<String> allBorrowedBooksString = new ArrayList<>();
		
		for (int i = 0; i < allBorrowedBooks.size(); i++){
			allBorrowedBooksString.add(allBorrowedBooks.get(i).toString());
		}
		
		String returnable = allBorrowedBooks.toString();
		
		return returnable;
	}
	
	@DeleteMapping ("/returnBookByISBN")
	public void returnBookByISBN(@RequestParam(value = "bookISBN", defaultValue = "incorrect input") String bookISBN) {
		borrowedBooksLibService.returnBookByISBN(bookISBN);
	}
	
	@GetMapping ("/getBorrowedBookByISBN")
	public String getBorrowedBookByISBN(@RequestParam (value = "ISBN", defaultValue = "incorrect input") String ISBN){
		borrowedBooksLibService = context.getBean(BorrowedBooksLibService.class);
		ISBN = String.valueOf(borrowedBooksLibService.getBorrowedBookByISBN(ISBN));
		return ISBN;
	}
	
	@GetMapping ("/getAllGroupRoomBookings")
	public String getAllGroupRoomBookings(){
		groupRoomLibService = context.getBean(GroupRoomLibService.class);
		ArrayList allGroupRoomBookings = groupRoomLibService.getAllGroupRoomBookings();
		
		ArrayList<String> allGroupRoomBookingsString = new ArrayList<>();
		
		for (int i = 0; i < allGroupRoomBookings.size(); i++){
			allGroupRoomBookingsString.add(allGroupRoomBookings.get(i).toString());
		}
		
		String returnable = allGroupRoomBookings.toString();
		
		return returnable;
	}
	
	@RequestMapping ("/add_groupRoom")
	public void addGroupRoom(@RequestParam(value = "groupRoomName", defaultValue = "incorrect input") String groupRoomName){
		
		groupRoomLibService.addGroupRoom(groupRoomName);
	}
	
	@DeleteMapping ("/deleteGroupRoomByID")
	public void deleteGroupRoomByID(@RequestParam(value = "groupRoomID", defaultValue = "incorrect input") String groupRoomID) {
		groupRoomLibService.deleteGroupRoomByID(groupRoomID);
	}
	
	@GetMapping ("/getGroupRoomByID")
	public String getGroupRoomByID(@RequestParam (value = "roomID", defaultValue = "incorrect input") String roomID){
		groupRoomLibService = context.getBean(GroupRoomLibService.class);
		roomID = String.valueOf(groupRoomLibService.getGroupRoomByID(roomID));
		return roomID;
	}
	
	@DeleteMapping ("/deleteGroupRoomBooking")
	public void deleteGroupRoomBookingByID(@RequestParam(value = "roomResID", defaultValue = "incorrect input") String roomResID) {
		groupRoomLibService.deleteGroupRoomBookingByID(roomResID);
	}
	
	@GetMapping ("/getGroupRoomBookingByID")
	public String getGroupRoomBookingByID(@RequestParam (value = "roomResID", defaultValue = "incorrect input") String roomResID){
		groupRoomLibService = context.getBean(GroupRoomLibService.class);
		roomResID = String.valueOf(groupRoomLibService.getGroupRoomBookingByID(roomResID));
		return roomResID;
	}
	
	@RequestMapping ("/book_groupRoom")
	public void bookGroupRoom(@RequestParam(value = "valuesAsCSV", defaultValue = "incorrect input") String valuesAsCSV){
		String[] separatedValues = valuesAsCSV.split(",");
		
		groupRoomLibService.bookGroupRoom(separatedValues[1], separatedValues[2], separatedValues[3]);
	}
	
	@GetMapping ("/getIsBookAvailable")
	public String getIsBookAvailable(@RequestParam (value = "isBookAvailable", defaultValue = "incorrect input") String isBookAvailable){
		bookLibService = context.getBean(BookLibService.class);
		isBookAvailable = String.valueOf(bookLibService.getIsBookAvailable(isBookAvailable));
		return isBookAvailable;
	}
}

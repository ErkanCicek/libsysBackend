package com.libsysbackend.libsysbackend.entity.BorrowedBooks;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "borrowedbooks/", method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
public class BorrowedBooksController {
    private final BorrowedBooksService borrowedBooksService;

    public BorrowedBooksController(BorrowedBooksService borrowedBooksService) {
        this.borrowedBooksService = borrowedBooksService;
    }

    @PostMapping ("post/newBorrowedBook")
    public String insertBorrowedBooks(@RequestParam("returnDate")String returnDate,
                                      @RequestParam("ISBN")String bookISBN,
                                      @RequestParam("bookId") int bookId,
                                      @RequestParam("SSN")String borrowerSSN){
        return this.borrowedBooksService.insertBorrowedBooks(returnDate, bookISBN, String.valueOf(bookId),borrowerSSN);
    }

    @GetMapping("get/borrowedBooksBySSN")
    public String getBorrowedBooksBySSN(@RequestParam("value")String ssn_in){
        return this.borrowedBooksService.getBorrowedBooksBySSN(ssn_in);
    }
    @GetMapping("get/getAllBorrowedBooksBySSN")
    public String getAllBorrowedBooksBySSN(@RequestParam("value")String SSN){
        return this.borrowedBooksService.getAllBorrowedBooksBySSN(SSN);
    }

    /*
    @GetMapping("get/allBorrowers")
    public String getAllBorrowers(){
        return this.borrowerService.getAllBorrowers();
    }
     */
}

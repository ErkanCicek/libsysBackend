package com.libsysbackend.libsysbackend.BorrowedBooks;

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
                                      @RequestParam("SSN")String SSN,
                                      @RequestParam("ISBN")String ISBN){
        return this.borrowedBooksService.insertBorrowedBooks(returnDate, SSN, ISBN);
    }
}

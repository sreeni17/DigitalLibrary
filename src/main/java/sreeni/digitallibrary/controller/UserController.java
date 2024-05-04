package sreeni.digitallibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.service.BookService;

import java.util.List;
import java.util.Set;

@RestController
public class UserController {

    @Autowired
    BookService bookService;


    @GetMapping("/books")
    public ResponseEntity<Set<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }


    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") String bookId) {
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
    }

    @PostMapping("{bookId}/review")
    public ResponseEntity<Book> addReview(@PathVariable("bookId") String bookId, @RequestBody Review review) {
         bookService.addReview(bookId, review);
         return new ResponseEntity<>(HttpStatus.CREATED);

    }
}

package sreeni.digitallibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.service.BookService;

@RestController
public class AdminController {

    @Autowired
    BookService bookService;


    @PostMapping("/admin/book")
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/admin/book")
    public ResponseEntity<Book> updateBook(@RequestParam("bookId") String id, @RequestBody Book book) {
        return new ResponseEntity<>(bookService.updateBook(id, book), HttpStatus.OK);
    }

    @DeleteMapping("/admin/book")
    public ResponseEntity<Book> deleteBook(@RequestParam String id) {
        bookService.deleteBook(id);
       return new ResponseEntity<>( HttpStatus.NO_CONTENT);
    }
}

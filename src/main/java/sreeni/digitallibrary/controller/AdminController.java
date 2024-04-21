package sreeni.digitallibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.service.BookService;

@RestController
public class AdminController {

    @Autowired
    BookService bookService;


    @PostMapping("/admin/book")
    public void createBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @PutMapping("/admin/book")
    public Book updateBook(@RequestParam("bookId") String id, @RequestBody Book book) {
        return bookService.updateBook(id, book);
    }

    @DeleteMapping("/admin/book")
    public void deleteBook(@RequestParam String id) {
        bookService.deleteBook(id);
    }
}

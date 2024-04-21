package sreeni.digitallibrary.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.service.BookService;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    BookService bookService;

    @GetMapping("/a")
    public String sayHello() {
        return "Hi";
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{id}")
    public Book getBook(@PathVariable("id") String bookId) {
        return bookService.getBook(bookId);
    }

    @PostMapping("{bookId}/review")
    public void addReview(@PathVariable("bookId") String bookId, @RequestBody Review review) {
         bookService.addReview(bookId, review);
    }
}

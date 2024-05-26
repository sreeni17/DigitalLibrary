package sreeni.digitallibrary.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.domain.User;
import sreeni.digitallibrary.service.BookService;

import java.util.List;
import sreeni.digitallibrary.service.UserService;
import sreeni.digitallibrary.service.resource.UserRequest;

@RestController
public class UserController {

    @Autowired
    BookService bookService;

    @Autowired
    UserService userService;


    @GetMapping("/books")
    public ResponseEntity<List<Book>> getAllBooks() {
        return new ResponseEntity<>(bookService.getAllBooks(), HttpStatus.OK);
    }


    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") Integer bookId) {
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
    }

    @PostMapping("{bookId}/review")
    public ResponseEntity<Book> addReview(@PathVariable("bookId") String bookId, @RequestBody Review review) {
         bookService.addReview(bookId, review);
         return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("register")
    public ResponseEntity<User> register(@RequestBody @Valid UserRequest userRequest) {
        userService.addUser(userRequest.toUser());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}

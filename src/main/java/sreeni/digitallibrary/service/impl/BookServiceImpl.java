package sreeni.digitallibrary.service.impl;

import java.sql.Connection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.repository.BookRepository;
import sreeni.digitallibrary.repository.ReviewRepository;
import sreeni.digitallibrary.service.BookService;

import java.util.*;
import sreeni.digitallibrary.service.resource.BookResponse;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private Connection connection;

    @Autowired
    BookRepository bookRepository;

    @Autowired
    ReviewRepository reviewRepository;

    public void setBookRepository(BookRepository bookRepository) {
      this.bookRepository = bookRepository;
    }

    public void addBook(Book book) {

      bookRepository.save(book);
    }

//    public List<BookResponse> getAllBooks() {
//
//      List <Book> books =  bookRepository.findAll();
//      List < BookResponse> bookResponses = new ArrayList<>();
//      for(Book book: books) {
//        List <Review> reviews = reviewRepository.findByBookId(book.getId());
//        bookResponses.add(BookResponse.builder().cost(book.getCost()).title(book.getTitle()).author(book.getAuthor()).rating(book.getRating()).reviewList(reviews).build());
//      }
//      return bookResponses;
//    }

      public List<Book> getAllBooks() {
      return  bookRepository.findAll();
      }



    public void deleteBook(Integer id) {
      bookRepository.deleteById(id);

    }

    public Book getBook(Integer id) {

      return bookRepository.findById(id).orElse(null);
    }

    public Book updateBook(Integer id, Book book) {
       Optional<Book> originalBook = bookRepository.findById(id);
       if(originalBook.isPresent()) {
         bookRepository.save(book);
       }
       return book;
    }

    @Override
    public void addReview(String bookId, Review review) {
//        if(bookMap.containsKey(bookId)) {
//          Book book = bookMap.get(bookId);
//          if(book !=null) {
////              book.getReviewList().add(review);
//              bookMap.put(bookId, book);
//          }
//        }

    }

}

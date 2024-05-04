package sreeni.digitallibrary.service.impl;

import org.springframework.stereotype.Service;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.service.BookService;

import java.util.*;

@Service
public class BookServiceImpl implements BookService {

    Map<String, Book> bookMap= new HashMap<>();
    private static int counter = 0;
    public void addBook(Book book) {

        book.setId(String.valueOf(counter+1));
        counter++;
        bookMap.put(book.getId(), book);
    }

    public Set<Book> getAllBooks() {
        return new HashSet<>(bookMap.values());
    }

    public void deleteBook(String id) {
        bookMap.remove(id);

    }

    public Book getBook(String id) {
       return bookMap.getOrDefault(id, null);
    }

    public Book updateBook(String id, Book book) {
       if(bookMap.containsKey(id)) {
            return   bookMap.put(id, book);
       }
        return null;
    }

    @Override
    public void addReview(String bookId, Review review) {
        if(bookMap.containsKey(bookId)) {
          Book book = bookMap.get(bookId);
          if(book !=null) {
              book.getReviewList().add(review);
              bookMap.put(bookId, book);
          }
        }

    }

}

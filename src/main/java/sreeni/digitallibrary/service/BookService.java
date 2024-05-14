package sreeni.digitallibrary.service;

import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;

import java.util.List;
import java.util.Set;
import sreeni.digitallibrary.service.resource.BookResponse;

public interface BookService {
    public void addBook(Book book);
    public List<Book> getAllBooks();
    public Book getBook(Integer id);

    public void deleteBook(Integer id);
    public Book updateBook(Integer id, Book book);

    public void addReview(String bookId, Review review);

}

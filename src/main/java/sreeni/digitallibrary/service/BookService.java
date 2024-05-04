package sreeni.digitallibrary.service;

import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;

import java.util.List;
import java.util.Set;

public interface BookService {
    public void addBook(Book book);
    public Set<Book> getAllBooks();
    public Book getBook(String id);

    public void deleteBook(String id);
    public Book updateBook(String id, Book book);

    public void addReview(String bookId, Review review);

}

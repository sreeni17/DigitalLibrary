package sreeni.digitallibrary.service.impl;

import org.springframework.stereotype.Service;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.service.BookService;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    private List<Book> bookList = new ArrayList<>();

    public void addBook(Book book) {
        bookList.add(book);
    }

    public List<Book> getAllBooks() {
        return bookList;
    }

    public void deleteBook(String id) {
        int index = -1;
        for(int i=0;i<bookList.size();i++) {
            if(bookList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if(index!= -1) {
            bookList.remove(index);
        }

    }

    public Book getBook(String id) {
        for (int i=0;i<bookList.size();i++) {
            if(bookList.get(i).getId().equals(id)) {
                return bookList.get(i);

            }
        }
        return null;
    }

    public Book updateBook(String id, Book book) {
        int index = -1;
        for(int i=0;i<bookList.size();i++) {
            if(bookList.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        if(index!= -1) {
            bookList.set(index, book);
            return bookList.get(index);
        }
        return  null;

    }

    @Override
    public void addReview(String bookId, Review review) {
        int index = -1;
        for(int i=0;i<bookList.size();i++) {
            if(bookList.get(i).getId().equals(bookId)) {
                index = i;
                break;
            }
        }
        if(index!= -1) {
            bookList.get(index).getReviewList().add(review);

        }
    }

}

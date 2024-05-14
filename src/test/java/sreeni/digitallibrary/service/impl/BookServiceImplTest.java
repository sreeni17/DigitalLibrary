package sreeni.digitallibrary.service.impl;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.repository.BookRepository;

class BookServiceImplTest {

  @BeforeAll
   public static void atFirst() {
    System.out.println("Starting test");
  }

  List <Book> bookList = new ArrayList<>();
  @BeforeEach
  public void setup() {
    System.out.println("Im running");
    Book book = new Book();
    bookList.add(book);
  }

  @AfterAll
  public static void atLast() {
    System.out.println("all test cases run");
  }

  @AfterEach
  public void afterEach() {
    System.out.println("After Each test case");
  }

  @Test
  void getAllBooks() {
    BookServiceImpl bookService = new BookServiceImpl();
    BookRepository bookRepository = mock(BookRepository.class);
    bookService.setBookRepository(bookRepository);
    when(bookRepository.findAll()).thenReturn(bookList);
    assertEquals(bookList.size(), 1);
    bookService.getAllBooks();

  }

  @Test
   void testGetAllBooks_EmptyList() {
    BookServiceImpl bookService = new BookServiceImpl();
    BookRepository bookRepository = mock(BookRepository.class);
    bookService.setBookRepository(bookRepository);
    List< Book> bookList = new ArrayList<>();
    when(bookRepository.findAll()).thenReturn(bookList);
    bookService.getAllBooks();
    assertEquals(bookList.size(), 0);
  }
}
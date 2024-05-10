package sreeni.digitallibrary;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Genre;
import sreeni.digitallibrary.repository.BookRepository;


@SpringBootApplication

public class DigitalLibraryApplicationImpl implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(DigitalLibraryApplicationImpl.class, args);
    }

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {

        Book book = new Book();
        book.setTitle("Hp-4");
        book.setAuthor("JK Rowling");
        book.setGenre(Genre.FANTASY);
        book.setRating(5.0);
        book.setCost(500.0);
        book.setYear(2000);
        bookRepository.save(book);
        List<Book> books = bookRepository.findAll();
        books = bookRepository.findByTitle("hi");
        for(Book b1:books){
            System.out.println(b1);
        }
    }

}

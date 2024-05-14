package sreeni.digitallibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import sreeni.digitallibrary.domain.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
  List<Book> findByTitle(String title);

  List<Book> findByAuthor(String author);


  List<Book> findByAuthorAndGenre(String author, String genre);

  // Method to find books by rating sorted in ascending order
  List<Book> findByOrderByRatingAsc();

  // Method to find books by rating sorted in descending order with pageable response
  Page<Book> findByOrderByRatingDesc(Pageable pageable);

  /**
   * Sample pageable request
   * // Create a Pageable object for the first page with 10 items per page, sorted by rating in descending order
   * Pageable pageable = PageRequest.of(0, 10, Sort.by("rating").descending());
   * */

  // Method to find average rating of books grouped by author
  @Query("SELECT b.author, AVG(b.rating) FROM Book b GROUP BY b.author")
  List<Book> findAverageRatingByAuthorWithCustomQuery();

  // without JPQL for average
  // Method to find average rating of books grouped by author
  List<Book> findAverageRatingByAuthor(String name);

  Page<Book> findByRating(Double rating, Pageable pageable);

  @Query("select book from Book book where title like ?1")
  List<Book> findByTitleLike(String title);

  @Query("select book from Book book where title like :title")
  List<Book> findByTitleLike2(String title);

  List<Book> findByRatingGreaterThan(double rating);

  @Query(value="select * from books where rating > ?",nativeQuery = true)
  List<Book> giveMeTopBooks(Double rating);

}

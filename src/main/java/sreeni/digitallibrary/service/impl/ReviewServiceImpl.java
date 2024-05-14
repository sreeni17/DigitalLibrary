package sreeni.digitallibrary.service.impl;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sreeni.digitallibrary.domain.Book;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.repository.BookRepository;
import sreeni.digitallibrary.repository.ReviewRepository;
import sreeni.digitallibrary.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

  @Autowired
  ReviewRepository reviewRepository;

  @Autowired
  BookRepository bookRepository;

  @Override
  public void addReview(Review review) {
    Optional<Book> bookOptional = bookRepository.findById(review.getBook().getId());
    if(bookOptional.isEmpty()) {
      throw new IllegalArgumentException("Book Id does not exist");
    }
    review.setBook(bookOptional.get());
    reviewRepository.save(review);
  }
}

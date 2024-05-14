package sreeni.digitallibrary.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sreeni.digitallibrary.domain.Review;
import sreeni.digitallibrary.repository.BookRepository;
import sreeni.digitallibrary.service.ReviewService;
import sreeni.digitallibrary.service.resource.ReviewRequest;

@RestController
@RequestMapping("/review")
public class ReviewController {
  @Autowired
  ReviewService reviewService;

  @PostMapping
  public ResponseEntity<?> addReview (@RequestBody @Valid ReviewRequest reviewRequest) {
    reviewService.addReview(reviewRequest.toReview());
    return new ResponseEntity<>(HttpStatus.CREATED);
  }
}

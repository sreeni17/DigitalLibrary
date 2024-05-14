package sreeni.digitallibrary.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sreeni.digitallibrary.domain.Review;
@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
  List<Review> findByBookId(Integer bookId);
}

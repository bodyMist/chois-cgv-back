package choiscgvback.cgv.repository.JpaRepository;

import choiscgvback.cgv.domain.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    //영화 상세 페이지, 해당 영화의 전체 리뷰 가져오기
    List<Review> findByMovie_Id(Long movieId);
}

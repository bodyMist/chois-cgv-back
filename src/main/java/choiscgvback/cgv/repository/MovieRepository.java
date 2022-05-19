package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    List<Movie> findAll();
    Optional<Movie> findById(Long id);

    // 메인페이지, 현재 상영중인 영화를 평점 내림차순으로 조회, page_size=5
    @Query("SELECT i.movie.id, AVG(i.score) FROM REVIEWS i " +
            "WHERE i.movie.id IN " +
            "(SELECT DISTINCT i.id FROM MOVIES i " +
            "LEFT OUTER JOIN Running r ON i.id = r.movie.id AND r.startTime > :now) " +
            "GROUP BY i.movie.id ORDER BY SUM(i.score) DESC")
    Slice<Movie> findByRunningAndReleaseDateWithPageable(LocalDateTime now, Pageable pageable);
    // 메인페이지, 현재 상영중인 영화를 평점 내림차순으로 조회, pagination X
    @Query("SELECT i.movie.id, AVG(i.score) FROM REVIEWS i " +
            "WHERE i.movie.id IN " +
            "(SELECT DISTINCT i.id FROM MOVIES i " +
            "LEFT OUTER JOIN Running r ON i.id = r.movie.id AND r.startTime > :now) " +
            "GROUP BY i.movie.id ORDER BY SUM(i.score) DESC")
    List<Movie> findByRunningAndReleaseDate(LocalDateTime now);
}

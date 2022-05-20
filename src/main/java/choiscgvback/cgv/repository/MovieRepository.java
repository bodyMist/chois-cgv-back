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
    @Query("SELECT avg(r.score), m.id, m.name, m.posterURL from MOVIES m " +
            "LEFT OUTER JOIN REVIEWS r on m.id = r.movie.id " +
            "WHERE m.id IN " +
            "(SELECT DISTINCT i.id FROM MOVIES i " +
            "LEFT OUTER JOIN Running r ON i.id = r.movie.id AND r.startTime > :now) " +
            "GROUP BY m.id ORDER BY AVG(r.score) DESC")
    Slice<Movie> findByRunningAndReleaseDateWithPageable(LocalDateTime now, Pageable pageable);
    // 메인페이지, 현재 상영중인 영화를 평점 내림차순으로 조회, pagination X
    @Query("SELECT avg(r.score), m.id, m.name, m.posterURL from MOVIES m " +
            "LEFT OUTER JOIN REVIEWS r on m.id = r.movie.id " +
            "WHERE m.id IN " +
            "(SELECT DISTINCT i.id FROM MOVIES i " +
            "LEFT OUTER JOIN Running r ON i.id = r.movie.id AND r.startTime > :now) " +
            "GROUP BY m.id ORDER BY AVG(r.score) DESC")
    List<Movie> findByRunningAndReleaseDate(LocalDateTime now);

    // 영화 페이지, 전체 영화 리스트 출력, 기본 예매율 정렬
    @Query("SELECT m.id, COUNT(m.id) from MOVIES m " +
            "INNER JOIN Running r on m.id = r.movie.id " +
            "AND r.startTime > :coming " +
            "LEFT OUTER JOIN TICKETS t ON r.id = t.running.id " +
            "GROUP BY m.id ORDER BY COUNT(m.id) DESC")
    List<Object> findMoviesSortWithTickets(LocalDateTime coming);
}

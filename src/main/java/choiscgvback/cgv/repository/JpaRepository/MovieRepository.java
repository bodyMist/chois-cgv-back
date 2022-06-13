package choiscgvback.cgv.repository.JpaRepository;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.dto.MoviePreviewDto;
import choiscgvback.cgv.repository.CustomRepository.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>, MovieCustomRepository {
    @EntityGraph(value = "movie_with_reviews")
    Optional<Movie> findById(Long id);

    // 메인페이지, 현재 상영중인 영화를 평점 내림차순으로 조회, page_size=5
    Page<Movie> findAll(Pageable pageable);

    // 메인페이지, 현재 상영중인 영화를 평점 내림차순으로 조회, pagination X
    @Query("SELECT new choiscgvback.cgv.dto.MoviePreviewDto(m.title, m.posterURL, AVG (r.score)) from MOVIES m " +
            "LEFT JOIN REVIEWS r on m.id = r.movie.id " +
            "LEFT JOIN Running rn ON m.id = r.movie.id " +
            "GROUP BY m.id ORDER BY AVG (r.score) DESC ")
    List<MoviePreviewDto> findByRunningAndReleaseDate();

    // 메인페이지, 전체 영화 리스트 출력, 기본 예매율 정렬, pagination X
    @Query("SELECT DISTINCT new choiscgvback.cgv.dto.MoviePreviewDto(m.title, m.posterURL, COUNT(t.id) as count) from MOVIES m " +
            "LEFT JOIN Running r on m.id = r.movie.id " +
            "LEFT JOIN TICKETS t ON t.running.id = r.id " +
            "GROUP BY m.id ORDER BY COUNT(t.id) DESC ")
    List<MoviePreviewDto> findMoviesSortWithTickets();
}

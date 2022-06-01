package choiscgvback.cgv.repository.JpaRepository;

import choiscgvback.cgv.domain.Running;
import choiscgvback.cgv.dto.TimetableDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface RunningRepository extends JpaRepository<Running, Long> {
    List<Running> findAll();

    // 현재 기준 4일 이내의 모든 상영 가져오기
    List<Running> findAllByStartTimeBefore(LocalDateTime criteria);

    // 상영시간표 페이지, 특정 날짜(내일~4일이내)의 모든 상영데이터 가져오기
    // 상영등급, 제목, 장르, 런타임, 개봉일, 상영관/층, 상영관의 총좌석과 잔여좌석
    @Query("SELECT DISTINCT new choiscgvback.cgv.dto.TimetableDto" +
            "(m.movieRating, m.title, m.genre, m.runningTime, " +
            "m.releaseDate, t.name, t.floor)" +
            "FROM Running r " +
            "LEFT JOIN MOVIES m ON r.movie.id = m.id " +
            "LEFT JOIN THEATERS t ON r.theater.id = t.id ")
    List<TimetableDto> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    // 예매페이지, 영화와 날짜를 토대로 모든 상영 가져오기
    @Query(value = "SELECT i FROM Running i WHERE i.movie_id = :movieId and Date(i.startTime) = Date(:criteria)", nativeQuery = true)
    List<Running> findAllByMovieIdAndDate(Long movieId, LocalDateTime criteria);

}

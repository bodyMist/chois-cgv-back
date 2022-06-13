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

    // 상영시간표 페이지, 특정 날짜(내일~4일이내)의 모든 상영데이터 가져오기
    // 상영등급, 제목, 장르, 런타임, 개봉일, 상영관/층, 상영관의 총좌석과 잔여좌석
    @Query("SELECT DISTINCT new choiscgvback.cgv.dto.TimetableDto" +
            "(r.id, m.movieRating, m.title, m.genre, m.runningTime, " +
            "m.releaseDate, r.startTime, t.name, t.floor, count(r), t.rowCount, t.columnCount) " +
            "FROM Running r " +
            "LEFT JOIN MOVIES m ON r.movie.id = m.id " +
            "LEFT JOIN THEATERS t ON r.theater.id = t.id " +
            "WHERE r.startTime >= :start AND r.startTime < :end " +
            "GROUP BY r.id ")
    List<TimetableDto> findByStartTimeBetween(LocalDateTime start, LocalDateTime end);

    // 예매페이지, 영화와 날짜를 토대로 모든 상영 가져오기
    @Query("SELECT DISTINCT new choiscgvback.cgv.dto.TimetableDto " +
            "(r.id, m.movieRating, m.title, m.genre, m.runningTime, " +
            "m.releaseDate, r.startTime, t.name, t.floor, count(r), t.rowCount, t.columnCount) " +
            "FROM Running r " +
            "LEFT JOIN MOVIES m ON r.movie.id = m.id " +
            "LEFT JOIN THEATERS t ON r.theater.id = t.id " +
            "WHERE r.movie.id = :movieId AND r.startTime >= :criteria " +
            "GROUP BY r.id")
    List<TimetableDto> findByMovie_IdAndStartTimeAfter(Long movieId, LocalDateTime criteria);

    // 관리자페이지, 모든 상영 계획 가져오기
    @Query("SELECT DISTINCT new choiscgvback.cgv.dto.TimetableDto " +
            "(r.id, m.movieRating, m.title, m.genre, m.runningTime, " +
            "m.releaseDate, r.startTime, t.name, t.floor, count(r), t.rowCount, t.columnCount) " +
            "FROM Running r " +
            "LEFT JOIN MOVIES m ON r.movie.id = m.id " +
            "LEFT JOIN THEATERS t ON r.theater.id = t.id " +
            "GROUP BY r.id")
    List<TimetableDto> findAllTimetable();
}

package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Running;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

public interface RunningRepository extends JpaRepository<Running, Long> {
    Running save(Running newSchedule);
    List<Running> findAll();

    @Query("SELECT i FROM Running i WHERE i.movie.id = :movieId")
    List<Running> findByMovieId(Long movieId);

    // 현재 기준 4일 이내의 모든 상영 가져오기
    List<Running> findAllByStartBefore(LocalDateTime criteria);

    // 예매페이지, 영화와 날짜를 토대로 모든 상영 가져오기
    @Query(value = "SELECT i FROM Running i WHERE i.movie.id = :movieId and Date(i.start) = Date(:criteria)", nativeQuery = true)
    List<Running> findAllByMovieIdAndDate(Long movieId, LocalDateTime criteria);
}

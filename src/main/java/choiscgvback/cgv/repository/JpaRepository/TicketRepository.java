package choiscgvback.cgv.repository.JpaRepository;

import choiscgvback.cgv.domain.Ticket;
import choiscgvback.cgv.dto.MovieStatisticDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TicketRepository extends JpaRepository<Ticket, Long>{
    // 영화 상세 페이지
    // 특정 영화의 전체 예매 count, 예매에서 남여 각각에 대한 count, 나이대별 count
//    @Query("SELECT m.sex, m.age/10 as age_group, COUNT(t.id) FROM TICKETS t " +
//            "LEFT JOIN MEMBERS m on t.member.id = m.id " +
//            "INNER JOIN Running r on t.running.id = r.id AND r.movie.id = :movieId " +
//            "GROUP BY m.sex, (m.age/10)")
//    List<MovieStatisticDto> getStatistic(Long movieId);
}

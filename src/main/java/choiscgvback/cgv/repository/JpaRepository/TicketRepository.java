package choiscgvback.cgv.repository.JpaRepository;

import choiscgvback.cgv.domain.Ticket;
import choiscgvback.cgv.dto.MovieStatisticDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long>{
    // 영화 상세 페이지
    // 특정 영화의 전체 예매 count, 예매에서 남여 각각에 대한 count, 나이대별 count
    @Query("SELECT new choiscgvback.cgv.dto.MovieStatisticDto(m.sex, (m.age/10) as age_group, COUNT(t.id) as count) FROM TICKETS t " +
            "LEFT JOIN MEMBERS m on t.member.id = m.id " +
            "LEFT JOIN TicketSeat ts on t.id = ts.ticket.id " +
            "JOIN Running r on t.running.id = r.id " +
            "WHERE r.movie.id = :movieId " +
            "GROUP BY m.sex, (m.age/10)")
    List<MovieStatisticDto> getStatistic(Long movieId);
}

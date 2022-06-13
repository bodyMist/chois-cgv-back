package choiscgvback.cgv.repository.JpaRepository;

import choiscgvback.cgv.domain.TicketSeat;
import choiscgvback.cgv.dto.TicketSeatDto;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TicketSeatRepository extends JpaRepository<TicketSeat, Long> {
    @Query("SELECT new choiscgvback.cgv.dto.TicketSeatDto(ts.id, s.rowNo, s.columnNo, s.type) " +
            "FROM TicketSeat ts LEFT JOIN SEATS s ON ts.seat.id = s.id ")
    List<TicketSeatDto> findByRunning_Id(Long runningId);
}

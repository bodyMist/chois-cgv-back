package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {
    // 예매를 위한 ticket 저장 & 예매취소
    Ticket saveAndFlush(Ticket newTicket);
}

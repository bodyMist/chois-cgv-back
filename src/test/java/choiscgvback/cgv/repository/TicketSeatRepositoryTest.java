package choiscgvback.cgv.repository;

import choiscgvback.cgv.repository.JpaRepository.TicketSeatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest
@Transactional
public class TicketSeatRepositoryTest {
    @Autowired
    TicketSeatRepository ticketSeatRepository;

    @Test
    void 좌석불러오기(){
        ticketSeatRepository.findByRunning_Id(1L)
                .forEach(o->{
                    System.out.println(o.getRowNo() + "/" +
                            o.getColumnNo() + "/"
                            + o.getType().getValue());
                });
    }
}

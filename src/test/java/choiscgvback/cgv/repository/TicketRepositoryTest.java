package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Member;
import choiscgvback.cgv.domain.Ticket;
import choiscgvback.cgv.repository.JpaRepository.MemberRepository;
import choiscgvback.cgv.repository.JpaRepository.TicketRepository;
import choiscgvback.cgv.repository.JpaRepository.TicketSeatRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class TicketRepositoryTest {
    @Autowired TicketRepository ticketRepository;
    @Autowired TicketSeatRepository ticketSeatRepository;
    @Autowired MemberRepository memberRepository;

//    @Test
//    void 엔티티_연관관계_영향_테스트(){
//        Member member = memberRepository.findById(1l).get();
//        System.out.println(member.getTickets().size());
//        Ticket ticket = ticketRepository.save(new Ticket(false, 10000, member));
//        member.getTickets().add(ticket);
//        System.out.println(member.getTickets().size());
//    }
}

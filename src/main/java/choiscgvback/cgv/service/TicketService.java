package choiscgvback.cgv.service;

import choiscgvback.cgv.domain.*;
import choiscgvback.cgv.dto.TicketDto;
import choiscgvback.cgv.model.DiscountPolicy;
import choiscgvback.cgv.repository.JpaRepository.TicketRepository;
import choiscgvback.cgv.repository.JpaRepository.TicketSeatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Service
@Transactional
@RequiredArgsConstructor
public class TicketService implements BaseService{
    private final TicketRepository ticketRepository;
    private final TicketSeatRepository ticketSeatRepository;
    // 예매 기능, 회원/영화/상영/상영관/좌석 받아서 저장
    public TicketDto ticket(Member member, Movie movie, Running running, Theater theater, List<Seat> seatList){
        AtomicInteger sum = new AtomicInteger();
        seatList.stream()
                .map(Seat::getPrice)
                .forEach(sum::addAndGet);
        DiscountPolicy discountPolicy = running.getPolicy();
        int price = discountPolicy.discount(sum.get());
        Ticket ticketResult = ticketRepository.save(new Ticket(false, sum.get(), member));

        seatList.forEach(seat -> {
            ticketSeatRepository.save(new TicketSeat(ticketResult, seat, running));
        });
        return new TicketDto(ticketResult);
    }
}

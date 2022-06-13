package choiscgvback.cgv.service;

import choiscgvback.cgv.domain.*;
import choiscgvback.cgv.dto.TicketDto;
import choiscgvback.cgv.dto.TicketSeatDto;
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

    // 예매-좌석 선택
    public List<TicketSeatDto> getReservedSeats(Long runningId){
        return ticketSeatRepository.findByRunning_Id(runningId);
    }

    // 예매 기능, 회원/영화/상영/상영관/좌석 받아서 저장
    public TicketDto ticket(Member member, Movie movie, Running running, List<Seat> seatList){
        AtomicInteger sum = new AtomicInteger(movie.getPrice());
        seatList.stream()
                .map(seat -> seat.getType().getValue())
                .forEach(sum::addAndGet);
        DiscountPolicy discountPolicy = running.getPolicy();
        int price = discountPolicy.discount(sum.get());
        Ticket ticketResult = ticketRepository.save(new Ticket(false, price, member, running));
        member.getTickets().add(ticketResult);
        seatList.forEach(seat -> {
            ticketSeatRepository.save(new TicketSeat(ticketResult, seat));
        });
        return new TicketDto(ticketResult);
    }
}

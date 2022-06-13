package choiscgvback.cgv.controller;

import choiscgvback.cgv.domain.*;
import choiscgvback.cgv.dto.TicketDto;
import choiscgvback.cgv.dto.TicketSeatDto;
import choiscgvback.cgv.service.RunningService;
import choiscgvback.cgv.service.TicketService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class TicketController {
    private final TicketService ticketService;
    private final RunningService runningService;

    @GetMapping("/ticket/{runningId}")
    public RunningSeat getSeats(@RequestParam("runningId") Long runningId){
        Running running = runningService.findById(runningId);
        List<TicketSeatDto> seats = ticketService.getReservedSeats(runningId);
        return new RunningSeat(running, seats);
    }

    @PostMapping("/ticket")
    public TicketDto ticketing(@RequestBody Member member,
                            @RequestBody Movie movie,
                            @RequestBody Running running,
                            @RequestBody List<Seat> seatList){
        TicketDto ticket = ticketService.ticket(member, movie, running, seatList);
        return ticket;
    }

    @Data
    @AllArgsConstructor
    class RunningSeat{
        Running running;
        List<TicketSeatDto> ticketSeatDto;
    }
}

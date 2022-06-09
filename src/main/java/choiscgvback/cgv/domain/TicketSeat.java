package choiscgvback.cgv.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NoArgsConstructor
public class TicketSeat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_SEAT_ID")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RUNNING_ID")
    private Running running;

    public TicketSeat(Ticket ticket, Seat seat, Running running) {
        this.ticket = ticket;
        this.seat = seat;
        this.running = running;
    }
}

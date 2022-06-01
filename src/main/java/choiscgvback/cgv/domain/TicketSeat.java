package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
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
}

package choiscgvback.cgv.domain;

import javax.persistence.*;

@Entity
public class TicketSeat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TICKET_SEAT_ID")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "TICKET_ID")
    private Ticket ticket;
    @ManyToOne
    @JoinColumn(name = "SEAT_ID")
    private Seat seat;
}

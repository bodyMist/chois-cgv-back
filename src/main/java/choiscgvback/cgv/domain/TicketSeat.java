package choiscgvback.cgv.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@NamedEntityGraph(name = "ticketseat-with-seat", attributeNodes = @NamedAttributeNode("seat"))
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

    public TicketSeat(Ticket ticket, Seat seat) {
        this.ticket = ticket;
        this.seat = seat;
    }
}

package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Running;
import choiscgvback.cgv.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class TicketDto {
    private final Long id;
    private final Boolean status;
    private final int price;
    private final Running running;

    public TicketDto(Ticket ticket) {
        this.id = ticket.getId();
        this.status = ticket.getStatus();
        this.price = ticket.getPrice();
        this.running = ticket.getRunning();
    }

    @Override
    public String toString() {
        return "\nTicketDto{" +
                "id=" + id +
                ", status=" + status +
                ", price=" + price +
                ", running=" + running +
                '}';
    }
}

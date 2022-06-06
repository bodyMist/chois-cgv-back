package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Ticket;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketDto {
    private final Long id;
    private final Boolean status;
    private final int price;

    public TicketDto(Ticket ticket) {
        this.id = ticket.getId();
        this.status = ticket.getStatus();
        this.price = ticket.getPrice();
    }
}

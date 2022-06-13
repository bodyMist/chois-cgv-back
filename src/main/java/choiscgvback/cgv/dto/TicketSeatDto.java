package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.SeatType;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TicketSeatDto {
    private final Long id;
    private final int rowNo;
    private final int columnNo;
    private final SeatType type;
}

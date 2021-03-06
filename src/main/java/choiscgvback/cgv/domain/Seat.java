package choiscgvback.cgv.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity(name = "SEATS")
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEAT_ID")
    private Long id;
    @NotNull
    private Integer rowNo;
    @NotNull
    private Integer columnNo;
    @NotNull
    @Enumerated(EnumType.STRING)
    private SeatType type;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;
}

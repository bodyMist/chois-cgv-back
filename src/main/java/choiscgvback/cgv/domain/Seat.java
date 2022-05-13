package choiscgvback.cgv.domain;

import javax.persistence.*;

@Entity
public class Seat {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "SEAT_ID")
    private Long id;
    @Column(name = "ROW")
    private Integer row;
    @Column(name = "COLUMN")
    private Integer column;
    @Column(name = "POSSIBILITY")
    private Boolean possibility;    // 0: 사용가능 1: 사용불가능

    @ManyToOne
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;
}

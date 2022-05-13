package choiscgvback.cgv.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_ID")
    private Long id;
    @Column(name = "FLOOR")
    private Integer floor;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.REMOVE)
    private List<Seat> seats = new ArrayList<>();
}

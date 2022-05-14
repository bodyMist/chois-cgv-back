package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_ID")
    private Long id;
    @NotNull
    private Integer floor;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.REMOVE)
    private List<Seat> seats = new ArrayList<>();
}

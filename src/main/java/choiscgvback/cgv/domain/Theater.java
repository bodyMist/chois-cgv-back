package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "THEATERS")
public class Theater {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "THEATER_ID")
    private Long id;
    @NotNull
    private Integer floor;
    @NotNull
    private String name;
    @NotNull
    private Integer rowCount;
    @NotNull
    private Integer columnCount;

    @OneToMany(mappedBy = "theater", cascade = CascadeType.REMOVE)
    private List<Seat> seats = new ArrayList<>();
}

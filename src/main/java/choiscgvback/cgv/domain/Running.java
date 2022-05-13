package choiscgvback.cgv.domain;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Running {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RUNNING_ID")
    private Long id;
    @Column(name = "START")
    private Timestamp start;
    @Column(name = "END")
    private Timestamp end;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;
}

package choiscgvback.cgv.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Entity
@Table(name = "MOVIES_WORKERS")
public class MovieWorker {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_WORKER_ID")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "WORKER_ID")
    private Worker worker;
}

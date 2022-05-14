package choiscgvback.cgv.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "RELEASE", nullable = false)
    private Timestamp release;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private Genre genre;
    @Enumerated(EnumType.STRING)
    @Column(name = "MOVIE_RATING")
    private MovieRating movieRating;

    @Column(name = "RUNNING", nullable = false)
    private Integer runningTime;

    @Column(name = "OPEN", nullable = false)
    private LocalDateTime openDate;
    @Column(name = "MODIFIED")
    private LocalDateTime modifiedDate;

    @Column(name = "SUMMARY")
    private String summary;
    @Column(name = "POSTER")
    private String posterURL;
    @Column(name = "TRAILER")
    private String trailerURL;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
}

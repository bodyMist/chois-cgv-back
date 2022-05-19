package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "MOVIES")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Long id;
    @NotNull
    private String name;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private MovieRating movieRating;
    @NotNull
    private Integer runningTime;
    @NotNull
    private LocalDateTime releaseDate;

    private LocalDateTime modifiedDate;
    private String summary;
    private String posterURL;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
}

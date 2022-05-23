package choiscgvback.cgv.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@NamedEntityGraph(
        name = "movie_with_running_and_reviews",
        attributeNodes = {
                @NamedAttributeNode("reviews"),
        }
        )
@Getter
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

    @OneToMany(mappedBy = "movie")
    private List<Running> runningList = new ArrayList<>();

    public float getScore() {
        return (float) (reviews.stream().mapToInt(Review::getScore).sum()) / reviews.size();
    }
}

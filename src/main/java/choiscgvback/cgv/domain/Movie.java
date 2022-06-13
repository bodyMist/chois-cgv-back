package choiscgvback.cgv.domain;

import lombok.Getter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


@NamedEntityGraphs(value = {
        @NamedEntityGraph(
                name = "movie_with_reviews",
                attributeNodes = {
                        @NamedAttributeNode(value = "reviews", subgraph = "review_with_like")
                },
                subgraphs = @NamedSubgraph(name = "review_with_like",
                attributeNodes = {
                        @NamedAttributeNode("likes"),
                        @NamedAttributeNode("member")
                })
        ),
        @NamedEntityGraph(
                name = "movie_with_workers",
                attributeNodes = {
                        @NamedAttributeNode("movieWorkers")
                }
        )
})
@Getter
@Entity(name = "MOVIES")
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Long id;
    @NotNull
    private String title;

    @Enumerated(EnumType.STRING)
    private Genre genre;
    @Enumerated(EnumType.STRING)
    private MovieRating movieRating;
    @NotNull
    private Integer runningTime;
    @NotNull
    private LocalDateTime releaseDate;

    private Integer price;
    private String summary;
    private String posterURL;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<Running> runningList = new ArrayList<>();

    @OneToMany(mappedBy = "movie")
    private List<MovieWorker> movieWorkers = new ArrayList<>();

    public float getScore() {
        return (float) (reviews.stream().mapToInt(Review::getScore).sum()) / reviews.size();
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", movieRating=" + movieRating +
                ", runningTime=" + runningTime +
                ", price=" + price +
                ", posterURL='" + posterURL + '\'' +
                ", \n reviews=" + reviews.toString() +
                '}';
    }
}

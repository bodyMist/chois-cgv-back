package choiscgvback.cgv.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Movie {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MOVIE_ID", nullable = false)
    private Long id;
    @Column(name = "NAME", nullable = false)
    private String name;
    @Column(name = "RELEASE", nullable = false)
    private Timestamp release;

    @ElementCollection(targetClass = Genre.class)
    @CollectionTable(name = "MOVIE_GENRES", joinColumns = @JoinColumn(name = "MOVIE_ID"))
    @Enumerated(EnumType.STRING)
    @Column(name = "GENRE")
    private Set<Genre> genres = new HashSet<>();

    @Column(name = "RUNNING", nullable = false)
    private Integer runningTime;

    @Column(name = "CREATED", nullable = false)
    @Temporal(value = TemporalType.TIMESTAMP)
    private Timestamp createdDate;
    @Column(name = "MODIFIED")
    @Temporal(value = TemporalType.TIMESTAMP)
    private Timestamp modifiedDate;

    @Column(name = "SUMMARY")
    private String summary;
    @Column(name = "POSTER")
    private String posterURL;
    @Column(name = "TRAILER")
    private String trailerURL;

    @OneToMany(mappedBy = "review", cascade = CascadeType.REMOVE)
    private List<Review> reviews = new ArrayList<>();
}

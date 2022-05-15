package choiscgvback.cgv.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity(name = "REVIEWS")
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEWS_ID")
    private Long id;
    @NotNull
    private Integer score;
    @NotNull
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
}

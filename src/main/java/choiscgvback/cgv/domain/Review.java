package choiscgvback.cgv.domain;

import javax.persistence.*;

@Entity
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEWS_ID")
    private Long id;
    @Column(name = "SCORE", nullable = false)
    private Integer score;
    @Column(name = "comment", nullable = false)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "MEMBER_ID")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;
}

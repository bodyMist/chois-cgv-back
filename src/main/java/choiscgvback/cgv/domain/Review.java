package choiscgvback.cgv.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity(name = "REVIEWS")
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
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

    @OneToMany(mappedBy = "review")
    private List<Like> likes = new ArrayList<>();

    @Override
    public String toString() {
        return "\nReview{" +
                ", member=" + member.getName() +
                ", score=" + score +
                ", comment='" + comment + '\'' +
                ", likes=" + likes.size() +
                '}';
    }
}

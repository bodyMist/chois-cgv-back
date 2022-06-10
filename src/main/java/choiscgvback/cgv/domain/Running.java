package choiscgvback.cgv.domain;

import choiscgvback.cgv.model.BaseDiscountPolicy;
import choiscgvback.cgv.model.DiscountPolicy;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Running {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RUNNING_ID")
    private Long id;
    @NotNull
    private LocalDateTime startTime;
    @NotNull
    private LocalDateTime endTime;
    @Transient
    private DiscountPolicy policy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;
}

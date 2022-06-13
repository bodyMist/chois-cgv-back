package choiscgvback.cgv.domain;

import choiscgvback.cgv.model.BaseDiscountPolicy;
import choiscgvback.cgv.model.DiscountPolicy;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    @JsonIgnore
    private DiscountPolicy policy = new BaseDiscountPolicy();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MOVIE_ID")
    private Movie movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "THEATER_ID")
    private Theater theater;

    @Override
    public String toString() {
        return "Running{" +
                "id=" + id +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", policy=" + policy.getClass() +
                ", movie=" + movie.getTitle() +
                '}';
    }
}

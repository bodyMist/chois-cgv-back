package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Genre;
import choiscgvback.cgv.domain.MovieRating;
import choiscgvback.cgv.model.BaseDiscountPolicy;
import choiscgvback.cgv.model.DiscountPolicy;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
public class TimetableDto {
    // 상영등급, 제목, 장르, 런타임, 개봉일, 시작날짜시간, 상영관 이름/층, 잔여좌석
    private final Long runningId;
    private final MovieRating movieRating;
    private final String title;
    private final Genre genre;
    private final int runningTime;
    private final LocalDateTime releaseDate;
    private final LocalDateTime startTime;
    private final String name;
    private final int floor;
    private final long count;
    private final int rowCount;
    private final int columnCount;
    private DiscountPolicy discountPolicy = new BaseDiscountPolicy();

    public TimetableDto(Long runningId, MovieRating movieRating,
                        String title, Genre genre, int runningTime,
                        LocalDateTime releaseDate, LocalDateTime startTime,
                        String name, int floor, long count, int rowCount, int columnCount) {
        this.runningId = runningId;
        this.movieRating = movieRating;
        this.title = title;
        this.genre = genre;
        this.runningTime = runningTime;
        this.releaseDate = releaseDate;
        this.startTime = startTime;
        this.name = name;
        this.floor = floor;
        this.count = count;
        this.rowCount = rowCount;
        this.columnCount = columnCount;
    }
}

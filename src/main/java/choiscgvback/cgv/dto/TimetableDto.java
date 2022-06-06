package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Genre;
import choiscgvback.cgv.domain.MovieRating;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@ToString
@Getter
@AllArgsConstructor
public class TimetableDto {
    // 상영등급, 제목, 장르, 런타임, 개봉일, 시작날짜시간, 상영관 이름/층, 잔여좌석
    private final MovieRating movieRating;
    private final String title;
    private final Genre genre;
    private final int runningTime;
    private final LocalDateTime releaseDate;
    private final LocalDateTime startTime;
    private final String name;
    private final int floor;
    private final long count;
}

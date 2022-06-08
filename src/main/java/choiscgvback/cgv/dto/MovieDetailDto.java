package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.MovieRating;
import choiscgvback.cgv.domain.Review;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
public class MovieDetailDto {
    private String title;
    private MovieRating movieRating;
    private Integer runningTime;
    private LocalDateTime releaseDate;
    private String summary;
    private String posterURL;
    private List<Review> reviews = new ArrayList<>();
    private List<MovieStatisticDto> statisticList = new ArrayList<>();

    public MovieDetailDto(Movie movie, List<MovieStatisticDto> statistic) {
        this.title = movie.getTitle();
        this.movieRating = movie.getMovieRating();
        this.runningTime = movie.getRunningTime();
        this.releaseDate = movie.getReleaseDate();
        this.summary = movie.getSummary();
        this.posterURL = movie.getPosterURL();
        this.reviews = movie.getReviews();
        this.statisticList = statistic;
    }
}

package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.MovieRating;
import choiscgvback.cgv.domain.MovieWorker;
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
    private List<MovieWorker> movieWorkers = new ArrayList<>();

    public MovieDetailDto(Movie movie, List<MovieStatisticDto> statistic) {
        this.title = movie.getTitle();
        this.movieRating = movie.getMovieRating();
        this.runningTime = movie.getRunningTime();
        this.releaseDate = movie.getReleaseDate();
        this.summary = movie.getSummary();
        this.posterURL = movie.getPosterURL();
        this.reviews = movie.getReviews();
        this.statisticList = statistic;
        this.movieWorkers = movie.getMovieWorkers();
    }

    public MovieDetailDto(Movie movie, List<Review> reviews,
                          List<MovieWorker> movieWorkers) {
        this.title = movie.getTitle();
        this.movieRating = movie.getMovieRating();
        this.runningTime = movie.getRunningTime();
        this.releaseDate = movie.getReleaseDate();
        this.summary = movie.getSummary();
        this.posterURL = movie.getPosterURL();
        this.reviews = reviews;
        this.movieWorkers = movieWorkers;
    }

    @Override
    public String toString() {
        return "MovieDetailDto{" +
                "title='" + title + '\'' +
                ", movieRating=" + movieRating +
                ", runningTime=" + runningTime +
                ", releaseDate=" + releaseDate +
                ", summary='" + summary + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", \nreviews=" + reviews.toString() +
                ", \nstatisticList=" + statisticList.toString() +
//                ", movieWorkers=" + movieWorkers.toString() +
                '}';
    }
}

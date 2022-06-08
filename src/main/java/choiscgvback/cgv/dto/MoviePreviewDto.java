package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.Review;
import lombok.Getter;

import java.util.List;

@Getter
public class MoviePreviewDto {
    private final String title;
    private final String posterURL;
    private long count;
    private double score;
    private List<Review> reviews;

    public MoviePreviewDto(String title, String posterURL, long count) {
        this.title = title;
        this.posterURL = posterURL;
        this.count = count;
    }
    public MoviePreviewDto(String title, String posterURL, double score) {
        this.title = title;
        this.posterURL = posterURL;
        this.score = score;
    }
    public MoviePreviewDto(Movie movie) {
        this.title = movie.getTitle();
        this.posterURL = movie.getPosterURL();
    }
}

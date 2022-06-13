package choiscgvback.cgv.dto;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.Review;
import lombok.Getter;

import java.util.List;

@Getter
public class MoviePreviewDto {
    private final String title;
    private final String posterURL;
    private Long count;
    private Double score;
    private List<Review> reviews;

    public MoviePreviewDto(String title, String posterURL, Long count) {
        this.title = title;
        this.posterURL = posterURL;
        this.count = count == null ? 0 : count;
    }
    public MoviePreviewDto(String title, String posterURL, Double score) {
        this.title = title;
        this.posterURL = posterURL;
        this.score = score == null ? 0 : score;
    }
    public MoviePreviewDto(Movie movie) {
        this.title = movie.getTitle();
        this.posterURL = movie.getPosterURL();
    }

    @Override
    public String toString() {
        return "MoviePreviewDto{" +
                "title='" + title + '\'' +
                ", posterURL='" + posterURL + '\'' +
                ", count=" + count +
                ", score=" + score +
                '}';
    }
}

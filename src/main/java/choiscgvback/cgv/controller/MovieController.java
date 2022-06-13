package choiscgvback.cgv.controller;


import choiscgvback.cgv.dto.MovieDetailDto;
import choiscgvback.cgv.dto.MoviePreviewDto;
import choiscgvback.cgv.service.MovieService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Slice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class MovieController {
    private final MovieService movieService;

    // 영화페이지, 정렬 기준에 따라 영화목록
    @GetMapping("/movies/{sort}")
    public List<MoviePreviewDto> getMovies(@PathVariable("sort")String sort){
        List<MoviePreviewDto> movies;
        switch (sort){
            case "review":
                movies = movieService.findRunningMovieWithReviews();
                break;
            case "ticket":
                movies = movieService.findRunningMovieWithTickets();
                break;
            default:
                movies = new ArrayList<>();
                break;
        }
        return movies;
    }
    // 메인페이지, 영화 pagenation
    @GetMapping("/movies/")
    public Slice<MoviePreviewDto> getMainpage(@RequestParam("page")int page){
        return movieService.findAll(page);
    }

    // 영화페이지, 영화 검색
    @GetMapping("/movies/search/")
    public List<MoviePreviewDto> searchMovie(@RequestParam("condition") String condition,
                                           @RequestParam("term") String term){
        List<MoviePreviewDto> movies;
        movies = movieService.searchMovie(condition, term);
        return movies;
    }

    @GetMapping("/movies/detail/{movieId}")
    public MovieDetailDto getMovieDetail(@PathVariable("movieId") Long movieId){
        MovieDetailDto movie = movieService.getMovieDetail(movieId);

        return movie;
    }
}

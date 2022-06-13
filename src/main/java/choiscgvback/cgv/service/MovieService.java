package choiscgvback.cgv.service;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.dto.MovieDetailDto;
import choiscgvback.cgv.dto.MoviePreviewDto;
import choiscgvback.cgv.dto.MovieStatisticDto;
import choiscgvback.cgv.repository.JpaRepository.MovieRepository;
import choiscgvback.cgv.repository.JpaRepository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService implements BaseService{
    private final MovieRepository movieRepository;
    private final TicketRepository ticketRepository;
    public Movie saveOne(Movie newMovie) {return movieRepository.save(newMovie);}
    public Movie findOne(Long movieId){return movieRepository.findById(movieId).get();}

    // 메인페이지, 현재 상영작 예평점순 조회(page_size=5)
    public Page<MoviePreviewDto> findAll(int page){
        Pageable pageRequest = PageRequest.of(page,5);
        List<MoviePreviewDto> list = movieRepository.findAll(pageRequest)
                .map(MoviePreviewDto::new)
                .stream().collect(Collectors.toList());
        Page<MoviePreviewDto> movies = new PageImpl<>(list);
        return movies;
    }
    // 메인페이지, 현재 상영작 평점순 조회
    public List<MoviePreviewDto> findRunningMovieWithReviews() {
        return movieRepository.findByRunningAndReleaseDate();
    }
    // 메인페이지, 현재 상영작 예매순 조회
    public List<MoviePreviewDto> findRunningMovieWithTickets() {
        return movieRepository.findMoviesSortWithTickets();
    }
    // 영화페이지, 검색기능
    public List<MoviePreviewDto> searchMovie(String condition, String term){
        List<MoviePreviewDto> result;
        switch (condition){
            case "title":
                result = movieRepository.findByTitle(term).stream()
                    .map(movie -> new MoviePreviewDto(movie)).collect(Collectors.toList());
                    break;
            case "actor":
                result = movieRepository.findByActor(term).stream()
                    .map(MoviePreviewDto::new).collect(Collectors.toList());
                break;
            default:
                result = new ArrayList<>();
                break;
        }
        return result;
    }
    // 영화 상세 페이지
    public MovieDetailDto getMovieDetail(Long movieId){
        MovieDetailDto movieDetail;
        Movie movie = movieRepository.findById(movieId).get();
        List<MovieStatisticDto> statisticList = ticketRepository.getStatistic(movieId);
        movieDetail = new MovieDetailDto(movie, statisticList);
        return movieDetail;
    }
}

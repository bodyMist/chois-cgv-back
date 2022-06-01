package choiscgvback.cgv.service;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.repository.JpaRepository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MovieService {
    private final MovieRepository movieRepository;
    public Movie saveOne(Movie newMovie) {return movieRepository.save(newMovie);}
    public Movie findOne(Long movieId){return movieRepository.findById(movieId).get();}

    // 메인페이지, 현재 상영작 예메순|평점순 조회(page_size=5)
    public Slice<Movie> findRunningMovie(int page){
        Pageable pageRequest = PageRequest.of(page,5, Sort.by(Sort.Direction.ASC, ""));
        return movieRepository.findByRunningAndReleaseDateWithPageable(LocalDateTime.now(), pageRequest);
    }
    // 메인페이지, 현재 상영작 예메순|평점순 조회
    public List<Movie> findRunningMovie(){
        return movieRepository.findByRunningAndReleaseDate(LocalDateTime.now());
    }

}

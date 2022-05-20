package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class MovieRepositoryTest {
    @Autowired private MovieRepository movieRepository;

    @Test
    void 영화_상영_그래프_탐색(){
        Optional<Movie> movie = movieRepository.findById(1L);
        System.out.println(movie.get().getName());
    }
    @Test
    void 메인페이지_영화출력_테스트(){
        List<Movie> movies = movieRepository.findByRunningAndReleaseDate(LocalDateTime.now());
        movies.stream().forEach(movie-> System.out.println(movie.getId()));
    }
}

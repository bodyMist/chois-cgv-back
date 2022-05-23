package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
public class MovieRepositoryTest {
    @Autowired private MovieRepository movieRepository;

    @Test
    void 영화_상영_그래프_탐색(){
        List<Movie> movie = movieRepository.findAll();
        movie.forEach(o -> System.out.println(o.getName() + " " + o.getRunningList()));
    }
    @Test
    void 메인페이지_영화출력_테스트(){
        List<Movie> movies = movieRepository.findByRunningAndReleaseDate(LocalDateTime.now());
        movies.stream().forEach(movie-> System.out.println(movie.getId()));
    }

    @Test
    void 영화_리뷰_총점_테스트(){
        Optional<Movie> movie = movieRepository.findById(1L);
        System.out.println(movie.get().getScore());
    }

    @Test
    void 영화_평점순_정렬(){
        List<Movie> movies = movieRepository.findAll();
        movies.stream().forEach(o -> {
            System.out.println(o.getName() + " " + o.getScore());
        });
    }
}

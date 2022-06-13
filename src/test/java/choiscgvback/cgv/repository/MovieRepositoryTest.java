package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.dto.MoviePreviewDto;
import choiscgvback.cgv.repository.JpaRepository.MovieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Transactional
@SpringBootTest
public class MovieRepositoryTest {
    @Autowired private MovieRepository movieRepository;
    @Autowired EntityManager em;

    @Test
    void 영화_상영_그래프_탐색(){
        List<Movie> movie = movieRepository.findAll();
        movie.forEach(o -> System.out.println(o.getTitle() + " " + o.getRunningList()));
    }
    @Test
    void 메인페이지_영화출력_평점순_테스트(){
        List<MoviePreviewDto> movies = movieRepository.findByRunningAndReleaseDate();
        movies.forEach(System.out::println);
    }
    @Test
    void 메인페이지_영화출력_예매율_테스트(){
        List<MoviePreviewDto> movies = movieRepository.findMoviesSortWithTickets();
        movies.forEach(System.out::println);
    }

    @Test
    void 영화_리뷰_총점_테스트(){
        System.out.println(movieRepository.findById(1L).get());
    }

    @Test
    void 영화_평점순_정렬(){
        List<Movie> movies = movieRepository.findAll();
        movies.stream().forEach(o -> {
            System.out.println(o.getTitle() + " " + o.getScore());
        });
    }

    @Test
    void QueryDSL_findByActor_테스트(){
        String actorName = "이명";
        List<Movie> movies = movieRepository.findByActor(actorName);
        movies.forEach(o->{
            System.out.println(o.getTitle() + "/" + o.getMovieWorkers());
        });

    }
}

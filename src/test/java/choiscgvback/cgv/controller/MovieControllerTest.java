package choiscgvback.cgv.controller;

import choiscgvback.cgv.dto.MoviePreviewDto;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class MovieControllerTest {
    @Autowired private MovieController movieController;

    @Test
    void 메인페이지_페이징(){
        movieController.getMainpage(0).forEach(System.out::println);
        movieController.getMainpage(1).forEach(System.out::println);
        movieController.getMainpage(2).forEach(System.out::println);

//        assertThat(movieController.getMainpage(0).getSize()).isEqualTo(5);
    }
    @Test
    void 영화페이지_평점순(){
        List<MoviePreviewDto> mainpage = movieController.getMovies("review");
        mainpage.forEach(System.out::println);
    }
    @Test
    void 영화페이지_예매순(){
        List<MoviePreviewDto> mainpage = movieController.getMovies("ticket");
        mainpage.forEach(System.out::println);
    }

    @Test
    void 영화_검색_테스트(){
        movieController.searchMovie("title", "주").forEach(System.out::println);
        movieController.searchMovie("actor", "worker").forEach(System.out::println);
    }

    @Test
    void 영화_상세페이지_테스트(){
        System.out.println(movieController.getMovieDetail(1L));
    }
}

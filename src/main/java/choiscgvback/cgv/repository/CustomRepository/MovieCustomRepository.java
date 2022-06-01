package choiscgvback.cgv.repository.CustomRepository;

import choiscgvback.cgv.domain.Movie;

import java.util.List;

public interface MovieCustomRepository {
    List<Movie> findByTitle(String title);
    List<Movie> findByActor(String actor);
}

package choiscgvback.cgv.repository.CustomRepository;

import choiscgvback.cgv.domain.Movie;

import java.util.List;

public interface MovieCustomRepository {
    public List<Movie> findByTitle(String title);
    public List<Movie> findByActor(String actor);
}

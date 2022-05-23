package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;

import java.util.List;

public interface MovieCustomRepository {
    List<Movie> findWithTitleOrActorDynamic(String word);
}

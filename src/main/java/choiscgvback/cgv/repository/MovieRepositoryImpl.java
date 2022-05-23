package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.QMovie;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MovieRepositoryImpl implements MovieCustomRepository{
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Movie> findWithTitleOrActorDynamic(String word) {

    }
}

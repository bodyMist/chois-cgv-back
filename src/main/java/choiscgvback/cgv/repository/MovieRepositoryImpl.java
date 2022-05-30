package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.QMovie;
import choiscgvback.cgv.domain.QMovieWorker;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MovieRepositoryImpl implements MovieCustomRepository {
    @PersistenceContext
    EntityManager em;

    @Autowired
    JPAQueryFactory query = new JPAQueryFactory(em);

    @Override
    public List<Movie> findByTitle(String title) {
        QMovie movie = QMovie.movie;

        return query
                .select(movie)
                .from(movie)
                .where(containMovieName(title))
                .fetch();
    }

    @Override
    public List<Movie> findByActor(String actor) {
        QMovie movie = QMovie.movie;

        return null;
    }


    private BooleanExpression containMovieName(String name){
        return name == null || name.isEmpty() ? null : QMovie.movie.name.contains(name);
    }
    private BooleanExpression containActorName(String name){
        return name == null || name.isEmpty() ? null : null;
    }
}

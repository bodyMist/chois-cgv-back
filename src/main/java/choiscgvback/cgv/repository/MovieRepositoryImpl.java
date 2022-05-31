package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.QMovie;
import choiscgvback.cgv.domain.QMovieWorker;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class MovieRepositoryImpl implements MovieCustomRepository {
    @PersistenceContext
    EntityManager em;
    JPAQueryFactory query = new JPAQueryFactory(em);

    @Override
    public List<Movie> findByTitle(String title) {
        QMovie movie = QMovie.movie;

        return query
                .selectFrom(movie)
                .where(containMovieName(title))
                .fetch();
    }

    @Override
    public List<Movie> findByActor(String actor) {
        QMovie movie = QMovie.movie;
        QMovieWorker movieWorker = QMovieWorker.movieWorker;

        return query
                .selectFrom(movie)
                .innerJoin(movie.movieWorkers)
                .leftJoin(movieWorker.worker)
                .on(containActorName(actor))
                .fetch();
    }


    private BooleanExpression containMovieName(String name){
        return name == null || name.isEmpty() ? null : QMovie.movie.name.contains(name);
    }
    private BooleanExpression containActorName(String name){
        return name == null || name.isEmpty() ? null : QMovieWorker.movieWorker.worker.name.contains(name);
    }
}

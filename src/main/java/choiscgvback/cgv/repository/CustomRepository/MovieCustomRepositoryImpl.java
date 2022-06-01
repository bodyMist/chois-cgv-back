package choiscgvback.cgv.repository.CustomRepository;

import choiscgvback.cgv.domain.Movie;
import choiscgvback.cgv.domain.QMovie;
import choiscgvback.cgv.domain.QMovieWorker;
import choiscgvback.cgv.domain.QWorker;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class MovieCustomRepositoryImpl implements MovieCustomRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    public List<Movie> findByTitle(String title) {
        QMovie movie = QMovie.movie;

        JPAQueryFactory query = new JPAQueryFactory(em);
        return query
                .selectFrom(movie)
                .where(containMovieName(title))
                .fetch();
    }

    @Override
    public List<Movie> findByActor(String actor) {
        QMovie movie = QMovie.movie;
        QMovieWorker movieWorker = QMovieWorker.movieWorker;
        QWorker worker = QWorker.worker;

        JPAQueryFactory query = new JPAQueryFactory(em);

        return query
                .selectFrom(movie)
                .leftJoin(movie.movieWorkers, movieWorker)
                .fetchJoin()
                .leftJoin(movieWorker.worker, worker)
                .fetchJoin()
                .where(containActorName(actor))
                .fetch();
    }


    private BooleanExpression containMovieName(String name){
        return name == null || name.isEmpty() ? null : QMovie.movie.name.contains(name);
    }
    private BooleanExpression containActorName(String name){
        return name == null || name.isEmpty() ? null : QMovieWorker.movieWorker.worker.name.contains(name);
    }
}

package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();
    // Create&Update
    Movie saveAndFlush(Movie newMovie);
}

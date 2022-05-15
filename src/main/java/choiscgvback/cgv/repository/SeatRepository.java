package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
    // seat insert&update
    Seat saveAndFlush(Seat newSeat);

}

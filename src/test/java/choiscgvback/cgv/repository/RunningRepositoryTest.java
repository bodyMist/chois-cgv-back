package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Running;
import choiscgvback.cgv.dto.TimetableDto;
import choiscgvback.cgv.repository.JpaRepository.RunningRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Transactional
@SpringBootTest
public class RunningRepositoryTest {
    @Autowired private RunningRepository runningRepository;

    @Test
    void 예매시간표_테스트(){
        List<TimetableDto> runningList = runningRepository
                .findByMovie_IdAndStartTimeAfter(1L, LocalDateTime.now());
        runningList.forEach(o->{
            System.out.println(o.toString());
        });
    }
    @Test
    void 상영시간표_테스트(){
        LocalDate start = LocalDate.of(2022,05,22);
        List<TimetableDto> runningList = runningRepository.findByStartTimeBetween(start.atStartOfDay(), start.plusDays(1).atStartOfDay());
        runningList.forEach(o->{
            System.out.println(o.toString());
        });
    }
}

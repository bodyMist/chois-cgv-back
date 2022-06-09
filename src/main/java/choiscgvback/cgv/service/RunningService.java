package choiscgvback.cgv.service;

import choiscgvback.cgv.dto.TimetableDto;
import choiscgvback.cgv.repository.JpaRepository.RunningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RunningService implements BaseService{
    private final RunningRepository runningRepository;

    // 상영시간표 페이지
    public List<TimetableDto> getRunning(){
        List<TimetableDto> timetableList = runningRepository.findByStartTimeBetween(LocalDateTime.from(LocalDate.now()), LocalDateTime.now().plusDays(5));
        return timetableList;
    }

    // 예매 단계, 특정 영화에 대한 모든 상영시간표(running)


    // 예매 단계, 특정 영화&상영관에 대한 상영시간표(running)
    public List<TimetableDto> getRunning(Long movieId){
        List<TimetableDto> timetableList = runningRepository.findByMovie_IdAndStartTimeAfter(movieId, LocalDateTime.now());
        return timetableList;
    }
}

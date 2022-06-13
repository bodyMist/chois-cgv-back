package choiscgvback.cgv.service;

import choiscgvback.cgv.domain.Running;
import choiscgvback.cgv.domain.Seat;
import choiscgvback.cgv.dto.TimetableDto;
import choiscgvback.cgv.model.DiscountPolicy;
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

    public Running findById(Long id){
        return runningRepository.findById(id).get();
    }

    // 상영시간표 페이지
    public List<TimetableDto> getRunning(){
        List<TimetableDto> timetableList = runningRepository.findByStartTimeBetween(LocalDate.now().atStartOfDay(), LocalDate.now().plusDays(1).atStartOfDay());
        return timetableList;
    }

    // 예매 단계, 특정 영화에 대한 모든 상영시간표(running)
    public List<TimetableDto> getRunning(Long movieId){
        List<TimetableDto> timetableList = runningRepository.findByMovie_IdAndStartTimeAfter(movieId, LocalDateTime.now());
        return timetableList;
    }

    // 관리자 페이지, 모든 상영시간표 가져오기
    public List<TimetableDto> getAllRunning(){
        return runningRepository.findAllTimetable();
    }

    // 관리자 페이지, 상영시간표에 대해 할인 정책 수정하기
    public TimetableDto updateDiscountPolicy(TimetableDto timetableDto, DiscountPolicy discountPolicy){
        timetableDto.setDiscountPolicy(discountPolicy);
        Running running = runningRepository.findById(timetableDto.getRunningId()).get();
        running.setPolicy(discountPolicy);
        return timetableDto;
    }
}

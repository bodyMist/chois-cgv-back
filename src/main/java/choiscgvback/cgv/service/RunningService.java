package choiscgvback.cgv.service;

import choiscgvback.cgv.dto.TimetableDto;
import choiscgvback.cgv.repository.JpaRepository.RunningRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class RunningService implements BaseService{
    private final RunningRepository runningRepository;

    // 상영시간표 페이지
    public List<TimetableDto> getRunning(){
        List<TimetableDto> result = new ArrayList<>();
        return result;
    }
}

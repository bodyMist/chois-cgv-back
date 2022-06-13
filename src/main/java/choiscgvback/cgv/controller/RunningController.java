package choiscgvback.cgv.controller;

import choiscgvback.cgv.domain.Running;
import choiscgvback.cgv.dto.TimetableDto;
import choiscgvback.cgv.model.DiscountPolicy;
import choiscgvback.cgv.service.RunningService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@AllArgsConstructor
public class RunningController {
    private final RunningService runningService;
    @GetMapping("/running")
    public List<TimetableDto> getTomorrowRunning(){
        return runningService.getRunning();
    }

    @GetMapping("/running/all")
    public List<TimetableDto> getAllRunning(){
        return runningService.getAllRunning();
    }

    @PutMapping("/running/update")
    public TimetableDto updateDiscountPolicy(@RequestBody TimetableDto timetableDto,
                                        @RequestBody DiscountPolicy discountPolicy){
        return runningService.updateDiscountPolicy(timetableDto, discountPolicy);
    }
}

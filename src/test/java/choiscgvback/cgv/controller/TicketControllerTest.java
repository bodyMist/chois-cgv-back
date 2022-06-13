package choiscgvback.cgv.controller;

import choiscgvback.cgv.dto.TimetableDto;
import choiscgvback.cgv.model.DiscountPolicy;
import choiscgvback.cgv.model.MorningDiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TicketControllerTest {
    @Autowired private RunningController runningController;

    @Test
    void 상영시간표_테스트(){
        runningController.getTomorrowRunning().forEach(System.out::println);
    }

    @Test
    void 할인정책_변경_테스트(){
        List<TimetableDto> running = runningController.getAllRunning();
        running.forEach(System.out::println);
        DiscountPolicy newPolicy = new MorningDiscountPolicy();
        runningController.updateDiscountPolicy(running.get(0), newPolicy);
    }
}

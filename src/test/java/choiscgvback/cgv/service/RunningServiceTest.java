package choiscgvback.cgv.service;


import choiscgvback.cgv.dto.TimetableDto;
import choiscgvback.cgv.model.MorningDiscountPolicy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
@Transactional
public class RunningServiceTest {
    @Autowired private RunningService runningService;

    @Test
    void 할인정책_수정_테스트(){
        List<TimetableDto> running = runningService.getAllRunning();
        System.out.println(running.toString());
        System.out.println();
        running.forEach(o->{
            o.setDiscountPolicy(new MorningDiscountPolicy());
        });
        System.out.println(running.toString());
    }
}

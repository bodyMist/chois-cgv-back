package choiscgvback.cgv.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
public class MemberControllerTest {
    @Autowired private MemberController memberController;

    @Test
    void 마이페이지_테스트(){
        System.out.println(memberController.getMemberDetail(1L));
    }
}

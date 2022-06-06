package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Member;
import choiscgvback.cgv.dto.MypageDto;
import choiscgvback.cgv.repository.JpaRepository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@SpringBootTest
@Transactional
public class MemberRepositoryTest {
    @Autowired private MemberRepository memberRepository;

    @Test
    void 마이페이지_테스트(){
        Optional<Member> member = memberRepository.findById(1L);
        MypageDto mypage = new MypageDto(member.get());
        System.out.println(mypage);
    }
}

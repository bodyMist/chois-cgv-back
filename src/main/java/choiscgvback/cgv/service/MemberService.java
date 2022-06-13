package choiscgvback.cgv.service;

import choiscgvback.cgv.domain.Member;
import choiscgvback.cgv.dto.MypageDto;
import choiscgvback.cgv.repository.JpaRepository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService implements BaseService{
    private final MemberRepository memberRepository;
    public Member login(Member member){
        String account = member.getAccount();
        String password = member.getPassword();
        return memberRepository.findMemberByAccountEqualsAndPasswordEquals(account, password);
    }

    // 마이페이지
    public MypageDto getMemberDetail(Long memberId){
        return new MypageDto(memberRepository.findById(memberId).get());
    }
}

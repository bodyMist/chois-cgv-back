package choiscgvback.cgv.repository;

import choiscgvback.cgv.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 로그인
    List<Member> findMemberByAccountEqualsAndPasswordEquals(String account, String password);

}

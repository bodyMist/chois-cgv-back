package choiscgvback.cgv.repository.JpaRepository;

import choiscgvback.cgv.domain.Member;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 로그인
    Member findMemberByAccountEqualsAndPasswordEquals(@NotNull String account, @NotNull String password);

    @EntityGraph(value = "member-with-tickets")
    Optional<Member> findById(Long id);
}

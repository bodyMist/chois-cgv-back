package choiscgvback.cgv.controller;

import choiscgvback.cgv.config.SessionConst;
import choiscgvback.cgv.domain.Member;
import choiscgvback.cgv.dto.MypageDto;
import choiscgvback.cgv.service.MemberService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Slf4j
@RestController
@AllArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/{memberId}")
    public MypageDto getMemberDetail(@PathVariable("memberId") Long memberId){
        MypageDto memberDetail = memberService.getMemberDetail(memberId);
        /*
        * Validation
        * */
        return memberDetail;
    }

    @PostMapping("/login")
    public void login(HttpServletRequest request,
                        HttpServletResponse response,
                        @RequestBody Member member,
                        @RequestParam(defaultValue = "/") String redirectURL) throws IOException {

        Member login = memberService.login(member);
        HttpSession session = request.getSession();
        session.setAttribute(SessionConst.LOGIN_MEMBER, login);

        response.sendRedirect(redirectURL);
    }
}

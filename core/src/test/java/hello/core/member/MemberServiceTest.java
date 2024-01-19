package hello.core.member;

import hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    
//    MemberService memberService = new MemberServiceImpl();
    MemberService memberService;

    @BeforeEach // 매번 test 실행 전에 항상 실행, test 갯수만큼 그 전에 돎.
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService(); // 매 test 실행 시마다 새로 주입 받기 위해 분리
    }

    @Test
    void join(){
        // given
        Member member = new Member(1L, "memberA", Grade.VIP);
        
        // when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        // then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}

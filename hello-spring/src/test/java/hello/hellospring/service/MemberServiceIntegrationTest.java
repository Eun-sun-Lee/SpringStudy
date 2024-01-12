package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceIntegrationTest {

    // DI : 필드 주입 방식
    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository; // SpringConfig 파일에서 Configuration 해준대로 들어옴.

    @Test
    void 회원가입()  {
        // given (해당 데이터를 기반)
        Member member = new Member();
        member.setName("hello");

        // when (이걸 검증)
        Long saveId = memberService.join(member);

        // then (검증부)
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        // given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        // when
        memberService.join(member1);

        // try-catch 대신 assertThrows 사용
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));// 해당 예외가 터져야함.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

        // then
    }
}
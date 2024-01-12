package hello.hellospring;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
    @Bean // 스프링 빈으로 인식해 등록해줌.
    public MemberService memberService(){
        return new MemberService(memberRepository()); // 스프링 빈에 등록된 memberRepository를 memberService에 넣어줌.
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}

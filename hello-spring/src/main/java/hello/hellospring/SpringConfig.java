package hello.hellospring;

import hello.hellospring.aop.TimeTraceAop;
import hello.hellospring.repository.*;
import hello.hellospring.service.MemberService;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;

    @Autowired // 생성자가 하나인 경우에는 생략 가능
    public SpringConfig(MemberRepository memberRepository) { // 스프링 데이터 JPA가 만들어놓은 구현체가 등록이 됨.
        this.memberRepository = memberRepository;
    }

    @Bean // 스프링 빈으로 인식해 등록해줌.
    public MemberSer  vice memberService(){
        return new MemberService(memberRepository); // 스프링 빈에 등록된 memberRepository를 memberService에 넣어줌.
    }

//    @Bean // Aop
//    public TimeTraceAop timeTraceAop(){
//        return new TimeTraceAop();
//    }

//    @Bean
//    public MemberRepository memberRepository(){
////        return new MemoryMemberRepository();
////        return new JdbcMemberRepository(dataSource);
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }
}

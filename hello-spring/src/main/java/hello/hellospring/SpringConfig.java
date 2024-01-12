package hello.hellospring;

import hello.hellospring.repository.JdbcMemberRepository;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private DataSource dataSource;

    @Autowired // DI
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean // 스프링 빈으로 인식해 등록해줌.
    public MemberService memberService(){
        return new MemberService(memberRepository()); // 스프링 빈에 등록된 memberRepository를 memberService에 넣어줌.
    }

    @Bean
    public MemberRepository memberRepository(){
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }
}

package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 객체인지 테스트
    }

    @Test
    @DisplayName("이름 없이 타입으로만 조회")
    void findBeanByType() {
        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 객체인지 테스트
    }

    @Test
    @DisplayName("구체 타입으로 조회")
    void findBeanByName2() {
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class); // 스프링 컨테이너에 MemberServiceImpl(인스턴스 타입의) 객체가 등록돼있으면 조회가 됨.
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class); // memberService가 MemberServiceImpl의 객체인지 테스트
    }

    @Test
    @DisplayName("빈 이름으로 조회 X")
    void findBeanByNameX() { // NosuchBeanDefinitionException
//        ac.getBean("xxxxx", MemberService.class);
        assertThrows(NoSuchBeanDefinitionException.class, // 2. 해당 예외 터져야함.
                () -> ac.getBean("xxxxx", MemberService.class)); // 1. 이 로직 실행 시
    }
}

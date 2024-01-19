package hello.core.scan;

import hello.core.AutoAppConfig;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
public class AutoAppConfigTest {
    @Test
    void basicScan(){
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);

        MemberService memberService = ac.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);

        OrderServiceImpl bean = ac.getBean(OrderServiceImpl.class);
        MemberRepository memberRepository = bean.getMemberRepository();
        System.out.println("memberRepository = " + memberRepository);
    }

    @Test
    @DisplayName("자바 코드로 new한 객체에는 @Autowired 적용이 안돼 직접 필드 주입 불가 (스프링 컨테이너에서 객체를 가져와야 @Autowired가 적용되는 것)")
    void fieldInjectionTest() {
//        OrderServiceImpl orderService = new OrderServiceImpl();

//        orderService.createOrder(1L, "itemA", 10000);
    }
}

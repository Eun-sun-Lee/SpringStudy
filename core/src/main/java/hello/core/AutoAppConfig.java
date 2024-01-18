package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
// @Component가 붙은 어노테이션을 찾아 자동으로 스프링 빈으로 등록해줌.
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // AppConfig 파일과 충돌 날 수도 있으므로 제외시킴 (@Configuration 파일도 @Component이므로)
)

public class AutoAppConfig {
//    @Autowired MemberRepository memberRepository;
//    @Autowired
//    DiscountPolicy discountPolicy;
//
//    @Bean
//    OrderService orderService() {
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }

//    @Bean
//    OrderService orderService(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
//        return new OrderServiceImpl(memberRepository, discountPolicy);
//    }
}

package hello.itemservice;

import hello.itemservice.web.filter.LogFilter;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfig {

    @Bean
    public FilterRegistrationBean logFilter(){ // 스프링 부트가 WAS를 띄울 때 필터를 넣어줌.
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(1); // filter가 chain으로 여러개 들어갈 수 있기 때문에 순서 지정
        filterFilterRegistrationBean.addUrlPatterns("/*");// 모든 URL에 적용
        return filterFilterRegistrationBean;
    }
}

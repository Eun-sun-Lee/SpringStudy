package hello.itemservice;

import hello.itemservice.web.filter.LogFilter;
import hello.itemservice.web.filter.LoginCheckFilter;
import hello.itemservice.web.interceptor.LogInterceptor;
import jakarta.servlet.Filter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LogInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns("/css/**", "/*.ico", "/error");
    }

//    @Bean
    public FilterRegistrationBean logFilter(){ // 스프링 부트가 WAS를 띄울 때 필터를 넣어줌.
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LogFilter());
        filterFilterRegistrationBean.setOrder(1); // filter가 chain으로 여러개 들어갈 수 있기 때문에 순서 지정
        filterFilterRegistrationBean.addUrlPatterns("/*");// 모든 URL에 적용
        return filterFilterRegistrationBean;
    }

    @Bean
    public FilterRegistrationBean loginCheckFilter(){ // 스프링 부트가 WAS를 띄울 때 필터를 넣어줌.
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new LoginCheckFilter());
        filterFilterRegistrationBean.setOrder(2); // filter가 chain으로 여러개 들어갈 수 있기 때문에 순서 지정
        filterFilterRegistrationBean.addUrlPatterns("/*");// 해당 필터를 적용하지 않을 URL을 LoginCheckFilter 안에 whiteList로 생성하였기 때문에 여기선 모든 URL에 적용
        return filterFilterRegistrationBean;
    }
}

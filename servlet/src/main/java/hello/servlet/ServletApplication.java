package hello.servlet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan // 스프링 부트에서 서블릿을 쓰기 위한 어노테이션 -> 하위 패키지에서 서블릿을 찾아 자동으로 등록하여 실행할 수 있도록 도와줌.
@SpringBootApplication
public class ServletApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServletApplication.class, args);
	}

}

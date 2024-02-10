package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {

//    private final Logger log = LoggerFactory.getLogger(getClass()); // 현재 Class로 지정

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "Spring";

        System.out.println("name = " + name);

        log.trace("trace log = {}", name);
        log.debug("debug log = {}", name); // 현재 로그는 디버그할 때 봄. (개발 서버)
        log.info(" info log = {}", name); // 현재 로그는 중요한 정보 (운영 시스템에서도 봐야함)
        log.warn(" warn log = {}", name); // 현재 로그는 경고
        log.error("error log = {}", name); // 현재 로그는 에러 (에러 로그 남으면 alert를 띄우거나 별도의 파일로 보관 가능)

        return "ok";
    }
}

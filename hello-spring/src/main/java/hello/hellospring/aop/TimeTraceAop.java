package hello.hellospring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect // Aop
@Component // 스프링 빈으로 등록
public class TimeTraceAop {

    @Around("execution(* hello.hellospring.service..*(..))") // execution(패키지명..클래스명(파라미터))
    public Object execute(ProceedingJoinPoint joinPoint) throws Throwable{ // 예외가 터지면 예외를 던짐.
        long start = System.currentTimeMillis();
        System.out.println("START: " + joinPoint.toString());
        try{
            return joinPoint.proceed(); // 다음 메소드로 진행됨.(joinPoint마다 중간에 intercept 걸림)
        } finally{
            long finish = System.currentTimeMillis();
            long timsMs = finish - start;
            System.out.println("END: " + joinPoint.toString() + " " + timsMs + "ms");
        }
    }
}

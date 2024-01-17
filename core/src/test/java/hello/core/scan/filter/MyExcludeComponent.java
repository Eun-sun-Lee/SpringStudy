package hello.core.scan.filter;
import java.lang.annotation.*;

@Target(ElementType.TYPE) // Element.TYPE : class level에 붙음.
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {
    // MyExcludeComponent가 붙으면 컴포넌트 스캔에서 제외함.
}




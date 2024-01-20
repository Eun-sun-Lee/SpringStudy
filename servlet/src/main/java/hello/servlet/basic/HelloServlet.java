package hello.servlet.basic;

import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello") // 이름은 상관없음, /hello가 오면 실행
public class HelloServlet extends HttpServlet {

    // Servlet이 호출되면 Service 메서드가 호출됨.
    // HTTP 요청이 오면 WAS(서블릿 컨테이너)가 request, response 객체를 만들어 서블릿에 던져줌.
    @Override
    public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("request = " + request); // WAS 서버가 구현한 서블릿 구현체
        System.out.println("response = " + response);

        String username = request.getParameter("username");
        System.out.println("username = " + username);

        response.setContentType("text/plain"); // <header> 단순 문자
        response.setCharacterEncoding("utf-8"); // <header> 인코딩 정보
        response.getWriter().write("hello " + username); // <body> http 메시지 body에 데이터가 들어감.
    }
}

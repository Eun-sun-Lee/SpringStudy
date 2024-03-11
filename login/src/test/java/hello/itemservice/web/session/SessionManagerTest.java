package hello.itemservice.web.session;

import hello.itemservice.domain.member.Member;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.Session;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

import static org.assertj.core.api.Assertions.assertThat;

class SessionManagerTest {

    SessionManager sessionManager = new SessionManager();

    @Test
    void sessionTest() {

        // 인터페이스이기 때문에 스프링이 제공하는 MockHttpServletResponse 사용 (가짜로 기능 테스트 가능)
        MockHttpServletResponse response = new MockHttpServletResponse();

        // 세션 생성 (서버 -> 클라이언트)
        Member member = new Member();
        sessionManager.createSession(member, response);

        // 요청에 응답 쿠키 저장 (클라이언트 -> 서버)
        MockHttpServletRequest request = new MockHttpServletRequest();
        request.setCookies(response.getCookies());

        // 세션 조회
        Object result = sessionManager.getSession(request);
        assertThat(result).isEqualTo(member);

        // 세션 만료
        sessionManager.expire(request);
        Object expired = sessionManager.getSession(request);
        assertThat(expired).isNull();
    }
}

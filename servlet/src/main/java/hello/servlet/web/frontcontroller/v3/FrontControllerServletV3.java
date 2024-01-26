package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.ModelView;
import hello.servlet.web.frontcontroller.MyView;
import hello.servlet.web.frontcontroller.v2.ControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontcontroller.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontcontroller.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontcontroller.v3.controller.MemberSaveControllerV3;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerMap = new HashMap<>(); // request url, controller

    public FrontControllerServletV3() {
        // Mapping 정보를 담아둠.
        controllerMap.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerMap.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerMap.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 1) requestURI에 매핑된 컨트롤러 객체 생성
        String requestURI = request.getRequestURI();

        ControllerV3 controller = controllerMap.get(requestURI);
        if (controller == null){
            response.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
            return;
        }
        // 2) 각 컨트롤러에서의 불필요한 서블릿 종속을 피하기 위해 key(parameter)-value 값을 저장한 paramMap 생성
        Map<String, String> paramMap = createParamMap(request);

        // 3) 각 컨트롤러 호출
        ModelView mv = controller.process(paramMap); // 각 컨트롤러에서는 MyView 객체만 생성해서 반환함. (MyView-생성자 호출)

        // 4) 뷰 리졸버
        String viewName = mv.getViewName(); // 논리 이름
        MyView myView = viewResolver(viewName); // 물리 이름

        // 5) 뷰 렌더링
        myView.render(mv.getModel(), request, response); // MyView-render 함수 호출
    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        // paramMap
        Map<String, String> paramMap = new HashMap<>();
        // 모든 파라미터 이름 다 가져오기
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName))); // key(parameter)-value
        return paramMap;
    }
}

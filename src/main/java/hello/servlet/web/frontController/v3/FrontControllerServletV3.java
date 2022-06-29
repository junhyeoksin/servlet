package hello.servlet.web.frontController.v3;

import hello.servlet.web.frontController.ModelView;
import hello.servlet.web.frontController.MyView;
import hello.servlet.web.frontController.v2.controller.MemberFormControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberListControllerV2;
import hello.servlet.web.frontController.v2.controller.MemberSaveControllerV2;
import hello.servlet.web.frontController.v3.controller.MemberFormControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberListControllerV3;
import hello.servlet.web.frontController.v3.controller.MemberSaveControllerV3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV3", urlPatterns = "/front-controller/v3/*")
public class FrontControllerServletV3 extends HttpServlet {

    private Map<String, ControllerV3> controllerV1Map  = new HashMap<>();
    public FrontControllerServletV3() {
        controllerV1Map.put("/front-controller/v3/members/new-form", new MemberFormControllerV3());
        controllerV1Map.put("/front-controller/v3/members/save", new MemberSaveControllerV3());
        controllerV1Map.put("/front-controller/v3/members", new MemberListControllerV3());
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String requestURI = request.getRequestURI();
        System.out.println("request -> " + requestURI);

        ControllerV3 controller = controllerV1Map.get(requestURI);

        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            return;
        }

        //  개체 컬렉션을 반복하는 데 사용   asIterator    ( option + command + m ) 메서드를 밖으로 뺌
        Map<String, String> paramMap = createParamMap(request);
        ModelView mv = controller.process(paramMap);    // 꺼내온 것을 넣어줌

        // 논리이름 new-form
        String viewName = mv.getViewName();

        //   "/WEB-INF/views//new-form.jsp
        // viewResolver 호출 -> myView 반환
        MyView view = viewResolver(viewName);

        view.render(mv.getModel(), request, response);


    }

    private MyView viewResolver(String viewName) {
        return new MyView("/WEB-INF/views/" + viewName + ".jsp");
    }

    private Map<String, String> createParamMap(HttpServletRequest request) {
        Map<String, String> paramMap = new HashMap<>();   // map 생성
        request.getParameterNames().asIterator()   // 모든 request Parameter name 을 가져옴
                .forEachRemaining(paramName -> paramMap.put(paramName, request.getParameter(paramName)));   // map 에 반복을 하면서 키 값을 꺼내옴
        return paramMap;
    }
}

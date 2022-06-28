package hello.servlet.web.frontController.v1.controller;

import hello.servlet.web.frontController.v1.ControllerV1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MemberFormControllerV1 implements ControllerV1 {
    /**
     * Controller1 인터페이스로 구현한 컨트롤러
     */
    @Override
    public void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";    // /WEB_INF -> 컨트롤러 거쳐서 호출시키고 싶을 떄
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);   // 서버 안에서 내부적으로 호출이 발생한다.
    }
}

package hello.servlet.web.frontController;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }
    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // model 에 있는 데이터(key, value)를 다 꺼내서 request.setAttribute 로 key value 에 담아 놓는다.
        modelToRequestAttribute(model, request);  // model에 있는 것을 requestAttribute 로 바꾼다.
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }

    private void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        // model 에 있는 데이터(key, value)를 다 꺼내서 request.setAttribute 로 key value 에 담아 놓는다.
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}

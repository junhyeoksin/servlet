package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;
import java.util.stream.Stream;

@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {
    /**
     * request.getParameter() : 하나의 파라미터 이름에 대해서 하나의 값만 있을 때 사용
     * request.getParameterValue(): 파라미터 이름이 중복일 때 사용
     */

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("[전체파라미터 조회] - start");
//      Enumeration<String> parameterNames = request.getParameterNames();
        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName + " :  value = " + request.getParameter(paramName)));

        System.out.println("[단일 파라미터 조회] ");
        String username = request.getParameter("username");
        String age = request.getParameter("age");

        System.out.println("username = " + username);
        System.out.println("age = " + age);

        System.out.println("[이름이 같은 복수 파라미터 조회]");
        String[] usernames = request.getParameterValues("username");
        for(String name: usernames){
            System.out.println("username = " + name);
        }

//        Stream<String> stream = Arrays.stream(usernames);
//        stream.forEach(s -> System.out.println("스트림  = " + s));

        response.getWriter().write("ok");


    }
}

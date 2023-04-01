package hello.servlet.basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest reqest, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("HelloServlet.service");
        System.out.println("reqest = " + reqest);
        System.out.println("response = " + response);

        String username = reqest.getParameter("username");
        System.out.println("username = " + username);

        // header
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        // body
        response.getWriter().write("hello " + username);

    }
}

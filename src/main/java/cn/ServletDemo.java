package cn;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author suiyue
 * @description TODO
 * @date 2019/5/19 16:33
 */
public class ServletDemo extends HttpServlet {
    //servlet初始化
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("init-----");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
    //servlet核心方法 由service调用
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        writer.append("helloWorld");
        writer.print("HelloWorld!");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//      super.doPost(req, resp);
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        if (pwd.equals("123")) {
            resp.sendRedirect("/success.jsp");
        } else {
            resp.sendRedirect("/error.jsp");
        }

    }
}

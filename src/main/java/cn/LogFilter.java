package cn;

import javax.servlet.*;
import java.util.Date;

public class LogFilter implements Filter  {
    @Override
    public void  init(FilterConfig config) throws ServletException{
        String testParam = config.getInitParameter("test-param");
        System.out.println("Test Param: " + testParam);
    }
    @Override
    public void  doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException {

        String ipAddress = request.getRemoteAddr();
        System.out.println("IP "+ ipAddress + ", Time " + new Date().toString());

    }
    @Override
    public void destroy( ){
    }
}
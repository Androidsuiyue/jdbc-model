package cn.db;


import cn.util.ConnectionContext;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Servlet Filter implementation class TranactionFilter
 */
public class TranactionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public TranactionFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * 在了解完ThreadLocal类的特性之后，之后我们可以根据该类特性实现在事务的操作中Connection的不变问题。
	 *创建一个过滤器TranactionFilter
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		Connection connection = null;
		
		try {
			//对数据库连接进行绑定
			//1.获取连接
			connection = JDBCUtils.getConnection();
			
			//2. 相当于开启事务start transaction
			connection.setAutoCommit(false);
			
			//3. 利用 ThreadLocal 把连接和当前线程绑定
			ConnectionContext.getInstance().bind(connection);
			
			//4. 把请求转给目标 Servlet
			chain.doFilter(request, response);
			
			//5. 提交事务
			connection.commit();
		} catch (Exception e) {
			e.printStackTrace();
			
			//6. 回滚事务
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			
			HttpServletResponse resp = (HttpServletResponse) response;
			HttpServletRequest req = (HttpServletRequest) request;
			resp.sendRedirect(req.getContextPath() + "/error-1.jsp");
			
		} finally{
			//7. 解除绑定
			ConnectionContext.getInstance().remove();

			//8. 关闭连接
			JDBCUtils.release(connection);
			
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	@Override
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}

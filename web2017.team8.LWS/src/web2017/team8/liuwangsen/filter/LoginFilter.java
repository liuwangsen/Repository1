package web2017.team8.liuwangsen.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginFilter implements Filter
{
	@Override
	public void destroy()
	{
		
	}
	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException
	{
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;

		HttpSession session = request.getSession();
		String path = request.getRequestURI();

		if (path.contains("login.html")|| path.contains("main"))
		{
			System.out.println("1");
			arg2.doFilter(request, response);
			return;
		} else 
		{
			if (session.getAttribute("userName") == null)
			{
				System.out.println("2");
				request.getRequestDispatcher("login.html").forward(request, response);
			} else
			{
				arg2.doFilter(request, response);
			}
		}
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException
	{
		
	}

}

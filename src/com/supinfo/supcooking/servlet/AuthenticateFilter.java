package com.supinfo.supcooking.servlet;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supcooking.dao.jpa.JpaUserDao;
import com.supinfo.supcooking.entity.User;
import com.supinfo.supcooking.util.Hash256Service;
import com.supinfo.supcooking.util.NullOrEmpty;

/**
 * Servlet Filter implementation class AuthenticateFilter
 */
@WebFilter("/auth/*")
public class AuthenticateFilter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthenticateFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		JpaUserDao jpa = new JpaUserDao();
		
			// Test dans la session
		 	HttpServletRequest httpRequest = (HttpServletRequest) request;
	        HttpServletResponse httpResponse = (HttpServletResponse) response;
	        HttpSession session = httpRequest.getSession();
	        User user = (User) session.getAttribute("username");
	        
	        // Test dans le cookie
	        User uc = null;
	        for (Cookie cookie : httpRequest.getCookies()) {
				   if (cookie.getName().equals("_AUTH")) {
					    uc = jpa.getUserByToken(Hash256Service.hash256(cookie.getValue()));
				    }
				  }
	        
	        if(user == null || uc == null ) {
	            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login.jsp");
	            return;
	        }
	       chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}
	
	


}

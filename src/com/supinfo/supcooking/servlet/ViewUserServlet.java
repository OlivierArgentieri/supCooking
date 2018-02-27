package com.supinfo.supcooking.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supcooking.dao.jpa.JpaRecipeDao;
import com.supinfo.supcooking.dao.jpa.JpaUserDao;
import com.supinfo.supcooking.entity.Recipe;
import com.supinfo.supcooking.entity.User;
import com.supinfo.supcooking.util.Hash256Service;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/profile")
public class ViewUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, User> userAtt = new HashMap<String, User>();
		JpaUserDao jpau = new JpaUserDao();
				
		// Recherche du cookie _AUTH
		User u = null;
		HttpSession s  = request.getSession();
		
		if(s.getAttribute("user") != null)
		{
			u = (User) s.getAttribute("user");
			request.setAttribute("user", u);
		}
		else if (request.getCookies() != null) {
			 for (Cookie cookie : request.getCookies()) {
			   if (cookie.getName().equals("_AUTH")) {
			    u= jpau.getUserByToken(Hash256Service.hash256(cookie.getValue()));
			    }
			  }
			}
		
		 if (u != null && Long.valueOf(request.getParameter("id"))== u.getId()) {
			
			 request.setAttribute("user", u);
			// request.getRequestDispatcher("auth/profile.jsp?id="+ u.getId()).forward(request, response);
		 }
		 else {
			if(request.getParameter("id") != null)
			{
				try {
					u = jpau.findUserById(Long.valueOf(request.getParameter("id")));
				}
				catch(Exception e)
				{}
				
				if(u != null)
				{
					request.setAttribute("user", u);
					request.setAttribute("recipe", u.getRecipes());
				}
			}
			
			else {
				userAtt.put("user", null);
			}
		 }
		request.getRequestDispatcher("profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

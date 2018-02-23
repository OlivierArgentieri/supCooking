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

import com.supinfo.supcooking.dao.jpa.JpaUserDao;
import com.supinfo.supcooking.entity.User;
import com.supinfo.supcooking.util.Hash256Service;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/auth/profile")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditUserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> userAtt = new HashMap<String, String>();
		JpaUserDao jpa = new JpaUserDao();
		
		// Recherche du cookie _AUTH
		User u = null;
		HttpSession s  = request.getSession();
		
		if(s.getAttribute("user") != null)
		{
			u = (User) s.getAttribute("user");
			userAtt.put("username", u.getUsername());
			userAtt.put("address", u.getAddress());
			userAtt.put("description", u.getDescription());
			userAtt.put("firstName", u.getFirstName());
			userAtt.put("lastNAme", u.getLastName());
			userAtt.put("mail", u.getMail());
			userAtt.put("phoneNumer", u.getPhoneNumber());
			userAtt.put("postCode", u.getPostCode());
			
			request.setAttribute("user", userAtt);
		}
		
		else if (request.getCookies() != null) {
			for (Cookie cookie : request.getCookies()) {
				if (cookie.getName().equals("_AUTH")) {
					u= jpa.getUserByToken(Hash256Service.hash256(cookie.getValue()));
					}
			}
			if (u != null) {
				userAtt.put("username", u.getUsername());
				userAtt.put("address", u.getAddress());
				userAtt.put("description", u.getDescription());
				userAtt.put("firstName", u.getFirstName());
				userAtt.put("lastNAme", u.getLastName());
				userAtt.put("mail", u.getMail());
				userAtt.put("phoneNumer", u.getPhoneNumber());
				userAtt.put("postCode", u.getPostCode());
				
				request.setAttribute("user", userAtt);
				}
			}
		request.getRequestDispatcher("/auth/profile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}

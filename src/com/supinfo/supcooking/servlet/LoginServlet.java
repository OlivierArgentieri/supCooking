package com.supinfo.supcooking.servlet;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.sendRedirect("/supCooking/login.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> messages = new HashMap<String, String>();
		JpaUserDao jpa = new JpaUserDao();
		
		User u = new User();
		u.setUsername(request.getParameter("username"));
		u.setPassword(Hash256Service.hash256(request.getParameter("password")));
		String key = UUID.randomUUID().toString().toUpperCase() + "|" + u.getUsername() + "|" + LocalDateTime.now();
		u.setToken(Hash256Service.hash256(key));

		User connectedUser = jpa.connexionUser(u);
		
		if( connectedUser != null && request.getParameter("rmMe") != null) {
			System.out.println(connectedUser.getUsername());
			Cookie cnxCookie = new Cookie("_AUTH", key);
			response.addCookie(cnxCookie);
			messages.put("username", connectedUser.getUsername());
			request.setAttribute("messages", messages);

			response.sendRedirect("/supCooking/index");
		}
		
		else if(connectedUser != null)
		{
			HttpSession s =request.getSession();
			s.setAttribute("user", connectedUser);
			response.sendRedirect("/supCooking/index");
		}
		else
		{
			messages.put("user", "Utilisateur non reconnu");
        	request.setAttribute("messages", messages);
        	request.getRequestDispatcher("login.jsp").forward(request, response);
		}
		
		
	}
}

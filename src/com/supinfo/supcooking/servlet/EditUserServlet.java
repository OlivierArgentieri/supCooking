package com.supinfo.supcooking.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supcooking.dao.jpa.JpaUserDao;
import com.supinfo.supcooking.entity.Recipe;
import com.supinfo.supcooking.entity.User;
import com.supinfo.supcooking.util.Hash256Service;

/**
 * Servlet implementation class ProfileServlet
 */
@WebServlet("/auth/editProfile")
public class EditUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory em;
	
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
		// Recherche du cookie _AUTH
		JpaUserDao jpa = new JpaUserDao();
		
		User u = null;
		HttpSession s  = request.getSession();
		
		if(s.getAttribute("user") != null)
		{
			u = (User) s.getAttribute("user");
		}
		else if (request.getCookies() != null) {
			 for (Cookie cookie : request.getCookies()) {
			   if (cookie.getName().equals("_AUTH")) {
			    u= jpa.getUserByToken(Hash256Service.hash256(cookie.getValue()));
			    }
			  }
			}
		
		 if (u != null) {
			 request.setAttribute("user", u);
			 request.getRequestDispatcher("/auth/editProfile.jsp").forward(request, response);
		 }
		 
		 
		 request.getRequestDispatcher("index.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		JpaUserDao jpa = new JpaUserDao();
				
		User u = null;
		HttpSession s  = request.getSession();
		
		if(s.getAttribute("user") != null)
		{
			u = (User) s.getAttribute("user");
		}
		else if (request.getCookies() != null) {
			 for (Cookie cookie : request.getCookies()) {
			   if (cookie.getName().equals("_AUTH")) {
			    u= jpa.getUserByToken(Hash256Service.hash256(cookie.getValue()));
			    }
			  }
			}
		
		 if (u != null) {
			u.setAddress(request.getParameter("address"));
			u.setDescription(request.getParameter("description"));
			u.setFirstName(request.getParameter("firstName"));
			u.setLastName(request.getParameter("lastName"));
			u.setUsername(request.getParameter("username"));
			u.setMail(request.getParameter("mail"));
			
			jpa.updateUser(u);
			
			request.setAttribute("user", u);
			request.getRequestDispatcher("/auth/editProfile.jsp").forward(request, response);
		 }
		
	}
}

package com.supinfo.supcooking.servlet;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.supinfo.supcooking.dao.jpa.JpaUserDao;
import com.supinfo.supcooking.entity.User;

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
		response.sendRedirect("/supcooking/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 String userName = request.getParameter("username");
		 
		 JpaUserDao jpa = new JpaUserDao();
		 
		 User u = new User();
		 u.setUsername(request.getParameter("username"));
		
		// pour le SHA-256
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			md.update(request.getParameter("password").getBytes());
			u.setPassword(bytesToHex(md.digest()));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		 User connectedUser = jpa.connexionUser(u);
		 if( connectedUser != null) {
			 Cookie cnxCookie = new Cookie("connection", connectedUser.getId().toString());
			 response.addCookie(cnxCookie);
			 request.getRequestDispatcher("register.jsp").forward(request, response);
		 }
		else
		{
			request.getRequestDispatcher("login.html").forward(request, response);
		}
		
		
	}
	public static String bytesToHex(byte[] bytes) {
        StringBuffer result = new StringBuffer();
        for (byte byt : bytes) result.append(Integer.toString((byt & 0xff) + 0x100, 16).substring(1));
        return result.toString();
    }

}

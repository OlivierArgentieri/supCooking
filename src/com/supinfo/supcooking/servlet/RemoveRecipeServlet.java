package com.supinfo.supcooking.servlet;

import java.io.IOException;
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
 * Servlet implementation class RemoveRecipeServlet
 */
@WebServlet("/auth/rm_recipe")
public class RemoveRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		JpaRecipeDao jpa = new JpaRecipeDao();
		JpaUserDao jpau = new JpaUserDao();
		Recipe r = null;
		
		
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
			
			 if (u != null) {
				
				 request.setAttribute("user", u);
			 }
			
		if(request.getParameter("id") != null && u != null)
		{
			try {
				r = jpa.findRecipeById(Long.valueOf(request.getParameter("id")));
			}
			catch(Exception e)
			{}
			
			System.out.println(r.getId());
			if(r != null && r.getAuthor().getId() == u.getId())
			{
				jpa.removeRecipe(r);
			}
			
		}

		request.getRequestDispatcher("/ListRecipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

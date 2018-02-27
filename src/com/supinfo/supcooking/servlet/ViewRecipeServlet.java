package com.supinfo.supcooking.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcooking.dao.jpa.JpaRecipeDao;
import com.supinfo.supcooking.entity.Recipe;

/**
 * Servlet implementation class ViewRecipeServlet
 */
@WebServlet("/recette")
public class ViewRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewRecipeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		JpaRecipeDao jpa = new JpaRecipeDao();
		Recipe r = null;
		
		if(request.getParameter("id") != null)
		{
			try {
				r = jpa.findRecipeById(Long.valueOf(request.getParameter("id")));
			}
			catch(Exception e)
			{}
			
			if(r != null)
			{
				request.setAttribute("recipe", r);
			}
			else {
				request.getRequestDispatcher("index.jsp").forward(request, response);
			}
		}
		
		else {
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		request.getRequestDispatcher("viewRecipe.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

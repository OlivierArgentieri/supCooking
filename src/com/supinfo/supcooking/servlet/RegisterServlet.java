package com.supinfo.supcooking.servlet;

import java.awt.List;
import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.supinfo.supcooking.entity.*;
import java.util.*;

@WebServlet("/Register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		this.em = Persistence.createEntityManagerFactory("My-PU");
		super.init();
	}
	
	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		this.em.close();
		super.destroy();
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

		User user;
		user = new User();
		user.setAddress(request.getParameter("address"));
		user.setDescription(request.getParameter("description"));
		user.setFirstName(request.getParameter("firstName"));
		user.setLastName(request.getParameter("lastName"));
		user.setMail(request.getParameter("mail"));
		user.setPassword(request.getParameter("password"));
		user.setPostCode(request.getParameter("postCode"));
		user.setPhoneNumber(request.getParameter("phoneNumber"));
		user.setRecipe(new ArrayList<Recipe>());
		
		EntityManager em = this.em.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
        	et.begin();
        	em.persist(user);
        	em.flush();
        	 
        	et.commit();
        }
        
        finally {
			if (et.isActive()) et.rollback();
			em.close();
		}
		doGet(request, response);

	}

}

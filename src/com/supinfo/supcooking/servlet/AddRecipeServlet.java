package com.supinfo.supcooking.servlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Formatter;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.supinfo.supcooking.dao.jpa.JpaRecipeDao;
import com.supinfo.supcooking.dao.jpa.JpaUserDao;
import com.supinfo.supcooking.entity.Rate;
import com.supinfo.supcooking.entity.Recipe;
import com.supinfo.supcooking.entity.User;
import com.supinfo.supcooking.util.Hash256Service;
import com.supinfo.supcooking.util.extractFileName;

import javafx.util.converter.LocalTimeStringConverter;
import sun.util.locale.provider.DateFormatProviderImpl;

import java.sql.Time;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Servlet implementation class AddRecipeServlet
 */
@WebServlet({"/auth/newRecipe" })
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, maxFileSize = 1024 * 1024 * 10, maxRequestSize = 1024 * 1024 * 50)
public class AddRecipeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private EntityManagerFactory em;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddRecipeServlet() {
        super();
        this.em = Persistence.createEntityManagerFactory("My-PU");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.sendRedirect("/supCooking/auth/addRecipe.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String> messages = new HashMap<String, String>();    
		JpaUserDao jpa = new JpaUserDao();
		
		Recipe recipe;
		recipe = new Recipe();
		
		// Recherche du cookie _AUTH
		User u = null;
		HttpSession s  = request.getSession();
		
		if(s.getAttribute("user") != null)
		{
			u = (User) s.getAttribute("user");
			messages.put("username", u.getUsername());
			request.setAttribute("messages", messages);
		}
		else if (request.getCookies() != null) {
			 for (Cookie cookie : request.getCookies()) {
			   if (cookie.getName().equals("_AUTH")) {
			    u= jpa.getUserByToken(Hash256Service.hash256(cookie.getValue()));
			    }
			  }
			}
		
		recipe.setAuthor(u);
		
		// Upload Image
		PrintWriter out = response.getWriter();
		Part part = request.getPart("file");
		String fileName = extractFileName.ExtractFileName(part);
		// test de l'extension pour la sécurité 
		
		if (fileName.toLowerCase().contains("jpg")  || fileName.toLowerCase().contains("png") || fileName.toLowerCase().contains("jpeg"))		{
			String savePath = "C:\\Users\\User\\Desktop\\supCooking\\WebContent\\images" + File.separator + fileName;
			File fileSaveDir = new File(savePath);
			recipe.setImage(fileName);
			part.write(savePath + File.separator);
		}
		else {
			messages.put("error", "format de fichier incorrect, fichier accépté (jpeg, jpg, png)");
			request.setAttribute("messages", messages);

	        request.getRequestDispatcher("/auth/addRecipe.jsp").forward(request, response);
		}
		
		
		
		
		// String -> LocalTime -> Time (sql)
		int hours = Integer.parseInt(request.getParameter("cookingTime")) / 60;
		int minute =Integer.parseInt(request.getParameter("cookingTime")) % 60;
		System.out.println(hours);
		System.out.println(minute);

		recipe.setCookingTime(Time.valueOf(LocalTime.of(hours, minute)));
		// plus tard car besoin de récupérer d'une list d'un form
		//recipe.
		LocalDate localDate = LocalDate.now();
		recipe.setDate(Date.valueOf(localDate));
		recipe.setDescription(request.getParameter("description"));
		recipe.setDifficulty(Integer.parseInt(request.getParameter("difficulty")));
		// plus tard car besoin d'une list d'un form
		//
		//recipe.setIngredient(request.getParameter("difficulty"));
		recipe.setName(request.getParameter("name"));
		recipe.setTime(Time.valueOf(LocalTime.of(1, 02)));
		recipe.setRate(new Rate());
		
		
	
		EntityManager em = this.em.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        System.out.println(recipe.getName());

	    try {
	        et.begin();
	        em.persist(recipe);
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

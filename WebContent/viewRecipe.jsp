<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.supinfo.supcooking.entity.Recipe"%>
<%@page import="java.util.List"%>
<% Recipe r = (Recipe) request.getAttribute("recipe"); %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ include file="header.jsp" %>
	<%@ include file="navBar.jsp" %>
    <!-- detailReceipe -->
    <div class="container">
      <div class="receipe_detail">
        <div class="row d-flex align-items-center">
          <div class="col-lg-6">
            <h1 class="receipe_titre"><%=r.getName() %></h1>
          </div>

          <div class="col-lg-6 text-right">
            Recette proposé par :<br> <i class="far fa-user"></i> <a href="profile?id=<%=r.getAuthor().getId()%>"><i><%=r.getAuthor().getUsername()%></i></a>

          </div>
        </div>

        <div class="row">
          <div class="col-lg-6">
            <img class="img-fluid rounded" src="assets/images/<%=r.getImage()%>">
          </div>
          <div class="col-lg-6">
            <p>
              <b><u>Description de la recette :</u></b> <br>
             <%=r.getRecipeDescription()%>
              </p>
            <p>
              <b><u>Temps de préparation :</u></b> <br>
              <i class="fas fa-clock"></i> <%=r.getTime().getMinutes() + r.getCookingTime().getMinutes() %> minutes
            </p>
            <p>
              <b><u>Difficulté :</u></b> <br>
              <% for(int i = 1; i <= r.getDifficulty() ; i++) {%>	
                <i class="fas fa-star"></i>
              <% } if (r.getDifficulty() < 5) {%>
              
                    <%for (int i =r.getDifficulty(); i < 5; i++) {%>
                    <i class="far fa-star"></i>
                <%}} %>
            </p>
            <hr>
            <p>
              <b><u>Partager cette recette </b></u>
              <ul class="list-inline mb-0">
                  <li class="list-inline-item mr-3">
                    <a href="#">
                      <i style="color: #333;" class="fab fa-facebook fa-2x fa-fw"></i>
                    </a>
                  </li>
                  <li class="list-inline-item mr-3">
                    <a href="#">
                      <i style="color: #333;" class="fab fa-twitter fa-2x fa-fw"></i>
                    </a>
                  </li>
                  <li class="list-inline-item">
                    <a href="#">
                      <i style="color: #333;" class="fab fa-instagram fa-2x fa-fw"></i>
                    </a>
                  </li>
                </ul>
            </p>
          </div>
        </div>
        <div class="row recipe_head_section">
          <div class="col-lg-12 text-center">
            <hr>
            <h3 class="spacing_title">Préparation et Ingrédients</h3>
            <hr>
          </div>
        </div>
        <div class="row">
          <!-- Left -->
          <div class="col-lg-9 col-separator-right">
            <h3 class="receipe_titre">Etapes de préparation :</h3>
            <div class="btn-group" role="group" aria-label="cookingtime">
              <button type="button" class="btn btn-default">Temps Total: <%=r.getTime().getMinutes() + r.getCookingTime().getMinutes() %> minutes</button>
              <button type="button" class="btn btn-default"><i class="fas fa-utensils"></i> Préparation: <%=r.getTime().getMinutes() %> minutes</button>
              <button type="button" class="btn btn-default"><i class="fas fa-fire"></i> Cuisson: <%=r.getCookingTime().getMinutes() %> minutes</button>
            </div>
            <br><br>
            <p class="receipe_prep">
              <%=r.getText() %>
            </p> 
          </div>

          <!-- Right -->
          <div class="col-lg-3 col-separator-left">
            <h3 class="receipe_titre">Liste des ingrédients :</h3>
              <ul class="receipe_ingredients_list">
              </ul>
          </div>
        </div>
      </div>
    </div>
<%@ include file="footer.jsp" %>
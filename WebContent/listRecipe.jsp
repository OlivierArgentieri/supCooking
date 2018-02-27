<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.supinfo.supcooking.entity.Recipe"%>
<%@page import="java.util.List"%>
<%@ include file="header.jsp" %>
<%@ include file="navBar.jsp" %>
<% List<Recipe> Recettes = (List<Recipe>) request.getAttribute("recipes"); %>

<!-- List Recettes -->

    <div class="container">
      <div class="row">
        <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
          <div class="receipe_liste_bloc">

            <!-- <menu_item> -->
            <div class="receipe_item text-center">
              <div class="row">
                <h3>Nos fantasiques recettes</h3>
              </div>
            </div>
            <!-- </menu_item> -->

		<%	if(Recettes != null){ 
			for(Recipe r : Recettes) { %>
            <!-- <item> -->
            <div class="receipe_item">
                <div class="row">
                    <div class="col-lg-5 col-md-5 col-sm-5 hidden-xs">
                        <a href="recette?id=<%=r.getId()%>"><img class="img-fluid rounded receipe_first_img" src="assets/images/<%=r.getImage()%>"></a>
                    </div>
                    <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                        <h2 class="receipe_titre">
                            <a href="recette?id=<%=r.getId()%>" class="news_lien"><%=r.getName() %></a>
                        </h2>
                        <span class="text-muted"><b>Posté le <%=r.getDate() %></b></span>
                        <p class="text-justify">
                        	<%=r.getRecipeDescription() %>
                        </p>
                        <i class="far fa-thumbs-up fa-lg"></i> <span class="thumbs-number">[10]</span> &nbsp; &nbsp; <i class="far fa-thumbs-down thumbs-red fa-lg"></i> <span class="thumbs-number">[5]</span>

                        <hr>
                        <!-- Stars -->
                        <p>Difficulté :<br>
                        <% for(int i = 1; i <= r.getDifficulty() ; i++) {%>	
                        		<i class="fas fa-star"></i>
                      <% } if (r.getDifficulty() < 5) {%>
                      
                        		<%for (int i =r.getDifficulty(); i < 5; i++) {%>
                        		<i class="far fa-star"></i>
                        <%}} %>
                      </p>
                      <p>
                        Temps de préparation : <br>
                        <i class="fas fa-clock"></i> <%=r.getTime() %> minutes
                      </p>
                      <p>
                        Temps de cuisson : <br>
                        <i class="fas fa-clock"></i> <%=r.getCookingTime() %> minutes
                      </p>
                    </div>
                </div>
            </div>
            <!-- </item> -->

	<%}
	} %>
	
          </div>
        </div>
      </div>
    </div>
	
<%@ include file="footer.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<%@page import="com.supinfo.supcooking.entity.Recipe"%>
<%@page import="java.util.List"%>
<% List<Recipe> Recettes = (List<Recipe>) request.getAttribute("recipes"); %>
<%@ include file="header.jsp" %>
	<%@ include file="navBar.jsp" %>
      <!-- About -->
      <div class="dad">
        <div class="row" style="margin: 60px 0; text-align: center;">
          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <h1 class="full-title">"La bonne cuisine est honnete, sincere et simple."</h1>
          </div>
        </div>
        <div class="row" style="margin: 60px 0; text-align: center;">
          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="text-align: center;">
              <a class="fig">
                3547
                <span style="font-size: 14px;"><br/>RECETTES AJOUTEES</span>
              </a>
          </div>
          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="text-align: center;">
              <a class="fig">
                1152
                <span style="font-size: 14px;"><br/>UTILISATEURS ACTIFS</span>
              </a>
          </div>
          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="text-align: center;">
              <a class="fig">
                170
                <span style="font-size: 14px;"><br/>INGREDIENTS DIFFERENTS</span>
              </a>
          </div>
          <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12" style="text-align: center;">
              <a class="fig">
                74%
                <span style="font-size: 14px;"><br/>DE SATISFACTION</span>
              </a>
          </div>
        </div>
      </div>

      <!-- About Description Section -->
      <section class="bg-primary mb-0" id="about">
        <div class="bg-banner">
          <div class="container text-wrapper">
            <div class="title-arch"><h3>Notre vision de la cuisine</h3></div>
            <div class="row">
              <div class="col-lg-4 text-justify ml-auto">
                <p class="lead"><i>Preparer soi-meme les repas demande un peu plus de temps que d'ouvrir un plat cuisine achete a l'epicerie.
                  Mais cuisiner est un plaisir, et c'est sans doute une des meilleures maniere de transmettre notre amour aux gens qui nous entourent. 
                  C'est aussi un moyen de transmettre son savoir-faire !</i></p>
              </div>
              <div class="col-lg-4 text-justify mr-auto">
                <p class="lead"><i>C'est ici que nous intervenons, G2Oeufs a ete pense pour vous permettre de partager vos recettes, votre envie de la bonne cuisine et aider votre prochain.
                  <br> Que vous 
                  soyez un petit cuisinier ou un chef renommee tout le monde peut partager son envie de la bonne cuisine.</i> </p>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Top Product -->
      <div class="bg-secondary">       
          <div class="title-arch"><h2>Notre selection de recettes de la semaine</h2></div>
          
            <%	if(Recettes != null){ 
				for(Recipe r : Recettes) { %>
				<div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
			          style="background-image: url('assets/images/<%=r.getImage() %>');">
			                <div class="project-hover">
			                  <h3><%=r.getName() %></h3>
			                    <hr />
			                    <p><%=r.getRecipeDescription() %></p>
			                    <a href="#">Voir la recette</a>
			                </div>
			            </div>
				<%}
				} %>
          
          <div class="clearfix"></div>
          <div class="container text-center">
            <a href="recettes"><i class="far fa-plus-square fa-5x" style="margin: 25px;"></i></a>
          </div>
      </div>
      
 <%@ include file="footer.jsp" %>
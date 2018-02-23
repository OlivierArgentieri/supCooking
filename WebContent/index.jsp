<%@ page language="java" pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<%@include file="header.jsp"%>
		<%@ include file="navBar.jsp" %>
      <!-- About -->
      <div class="dad">
        <div class="row" style="margin: 60px 0; text-align: center;">
          <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
            <h1 class="full-title">“La bonne cuisine est honnête, sincère et simple.”</h1>
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
                <p class="lead"><i>Préparer soi-même les repas demande un peu plus de temps que d'ouvrir un plat cuisiné acheté à l'épicerie.
                  Mais cuisiner est un plaisir, et c'est sans doute une des meilleures manière de transmettre notre amour aux gens qui nous entourent. 
                  C'est aussi un moyen de transmettre son savoir-faire !</i></p>
              </div>
              <div class="col-lg-4 text-justify mr-auto">
                <p class="lead"><i>C'est ici que nous intervenons, G2Oeufs a été pensé pour vous permettre de partager vos recettes, votre envie de la bonne cuisine et aider votre prochain.
                  <br> Que vous 
                  soyez un petit cuisinier ou un chef renommé tout le monde peut partager son envie de la bonne cuisine.</i> </p>
              </div>
            </div>
          </div>
        </div>
      </section>

      <!-- Top Product -->
      <div class="bg-secondary">       
          <div class="title-arch"><h2>Notre séléction de recettes de la semaine</h2></div>
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated4 fadeInLeft"
          style="background-image: url('assets/image/gratin1.jpg');">
                <div class="project-hover">
                  <h3>Gratin Dauphinois</h3>
                    
                    <hr />
                    <p> La recette de vrai gratin Dauphinois, tel qu'il était préparée par nos grand-mères. Un plat économique, facile, plutôt rapide (demande peu de préparation), et dont tout le monde raffole..</p>
                    <a href="#">Voir la recette</a>
                </div>
            </div>
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated3 fadeInLeft" 
          style="background-image: url('assets/image/pizza1.jpg');">
              <div class="project-hover">
                  <h3>Pizza Jambon Fromage</h3>
                    <hr />
                    <p>Pour passer une bonne soirée avec vos amis, pensez aux classiques, comme la pizza jambon fromage. Découvrez la recette sans plus attendre.</p>
                    <a href="#">Voir la recette</a>
                </div>
            </div>
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated animated2 fadeInLeft" 
          style="background-image: url('assets/image/salade1.jpg');">
              <div class="project-hover">
                  <h3>Salade de concombre au chèvre et olives</h3>
                    <hr />
                    <p>Cet salade composé avec ses ingrédients frais et varié ravivra les papilles des plus gourmants ! Un plat rapide à préparer et délicieux.</p>
                    <a href="#">Voir la recette</a>
                </div>
            </div>
          <div class="col-xl-3 col-lg-3 col-md-3 col-sm-3 project wow animated fadeInLeft" 
          style="background-image: url(assets/image/pates1.jpg);">
            <div class="project-hover">
                <h3>Pâtes sauce Madère</h3>
                  <hr />
                  <p>Une sauce se mariant parfaitement avec quelques pâtes ou les viande rouges!</p>
                  <a href="#">Voir la recette</a>
            </div>
          </div>
          <div class="clearfix"></div>
          <div class="container text-center">
            <i class="far fa-plus-square fa-5x" style="margin: 25px;"></i>
          </div>
      </div>
<%@include file="footer.jsp"%>
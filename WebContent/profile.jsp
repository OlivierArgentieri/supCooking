<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.supinfo.supcooking.entity.User"%>
<%@page import="com.supinfo.supcooking.entity.Recipe"%>
<%@page import="java.util.List"%>
<% User u = (User) request.getAttribute("user"); %>
<% List<Recipe> mesRecettes = (List<Recipe>) request.getAttribute("recipe"); %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Website for manage recipe">
    <meta name="author" content="">

    <title>SupCooking Index</title>

    <!-- GoogleFonts -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat" rel="stylesheet">
    <!-- Bootstrap Core CSS -->
		<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!-- FontAwesome Core -->
    <link href="assets/vendor/fontawesome506/css/fontawesome-all.css" rel="stylesheet">
    <!-- Custom style theme -->
    <link href="assets/css/supcooking.css" rel="stylesheet">
    <!-- Custom plugins style theme -->
    <link href="assets/css/plugins.css" rel="stylesheet">
	</head>
	<!-- Start Body -->

  <body id="page-top">

    <!-- Navigation -->
    <div id="flipkart-navbar">
        <div class="container">
            <div class="row row1">
              <div class="col-sm-12">
                <ul class="largenav flipkart-menu-ul">
                    <li class="upper-links"><a class="links" href="index.html"> <i class="fas fa-home"></i> Accueil</a></li>
                    <li class="upper-links"><a class="links" href="#"> <i class="fas fa-tasks"></i> Toutes les recettes</a></li>
                    <li class="upper-links"><a class="links" href="#"> <i class="fas fa-random"></i> Recette aléatoire</a></li>
                    <li class="upper-links"><a class="links" href="#"> <i class="fas fa-pencil-alt"></i> Ecrire ma recette</a></li>
                    <!-- Moovers --><li class="up"></li>
                    <li class="upper-links"><a class="links" href="login.html"><i class="fas fa-users"></i> Connexion</a></li>
                </ul>
              </div>
            </div>
            <div class="row row2 d-flex align-items-center">
                <div class="col-sm-3">
                    <h2 style="margin:0px;"><span class="smallnav menu" onclick="openNav()"> <img class="img-fluid" src="assets/image/logo.png"></span></h2>
                    <h1 style="margin:0px;"><span class="largenav"><img class="img-fluid" src="assets/image/logo.png"></span></h1>
                </div>
                <div class="flipkart-navbar-search smallsearch col-sm-9 col-xs-12">
                    <div class="row">
                        <input id="search" class="flipkart-navbar-input col-sm-11 col-xs-10" type="" placeholder="Qu'allez vous manger ce soir ? Un bon petit plat ? Une pizza ?" name="search">
                        <button class="flipkart-navbar-button col-sm-1 col-xs-2">
                          <i class="fas fa-search"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div id="mySidenav" class="sidenav">
        <div class="container" style="background-color: #2874f0; padding-top: 10px;">
            <span class="sidenav-heading">G2Oeufs</span>
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">×</a>
        </div>
        <a href="http://clashhacks.in/">Recettes</a>
        <a href="http://clashhacks.in/">Aléatoire</a>
        <a href="http://clashhacks.in/">Ma recette</a>
        <a href="http://clashhacks.in/">Connexion</a>
    </div>
    
    <!-- profil -->
    <div class="container">
      <div class="receipe_detail">
        <div class="row">
          <div class="col-sm-12 text-center">
            <hr>
            <h3 class="spacing_title">Profil de Jean  <p><%=u.getUsername() %></p></h3>

           
				
            <hr>
          </div>
        </div>
        <!-- Statistics -->
        <div class="row">
            <div class="col-lg-4 col-md-6 text-center">
              <div class="mt-5 mx-auto">
                <i class="fas fa-4x fa-tasks text-primary mb-3 sr-icons"></i>
                <h3 class="mb-3">1575 Recettes</h3>
                <p class="text-muted mb-0">Mais que vois-je un vrai cuistot est présent ici, que dit-je un chef !</p>
              </div>
            </div>
            <div class="col-lg-4 col-md-6 text-center">
              <div class="mt-5 mx-auto">
                <i class="fas fa-4x fa-thumbs-up text-primary mb-3 sr-icons"></i>
                <h3 class="mb-3">54 Retours positifs</h3>
                <p class="text-muted mb-0">Un certain nombre de personnes ont l'air d'apprécier ses recettes.</p>
              </div>
            </div>
            <div class="col-lg-4 col-md-12 text-center">
              <div class="mt-5 mx-auto">
                <i class="fas fa-4x fa-thumbs-down text-primary mb-3 sr-icons"></i>
                <h3 class="mb-3">23 Retours négatifs</h3>
                <p class="text-muted mb-0">On ne le répétera pas mais les goûts et les couleurs ne se discutent pas..</p>
              </div>
            </div>
          </div>

        <!-- Recipes -->
        <div class="row">
            <div class="col-sm-12 text-center">
              <br><hr>
              <h3 class="spacing_title">Recettes écrites par Jean Bonnot</h3>
              <hr>
            </div>
          </div>
           <%	if(mesRecettes != null){ 
				} %>
				
            
					 <%  for(Recipe r : mesRecettes) { %>
					   <div class="row text-center">
          <div class="col-md-3">
            <br><a href="#"><img class="img-fluid rounded receipe_first_img" src="assets/image/pizza1.jpg"></a>
            <h5 class="receipe_more_title"><a href="#"><%=r.getName() %></a></h5>
            <div class="form-control text-center">
                <i class="far fa-thumbs-up fa-lg"></i> <span class="thumbs-number">[10]</span> &nbsp; &nbsp; <i class="far fa-thumbs-down fa-lg"></i> <span class="thumbs-number">[5]</span>
            </div>
				<% } %>
      
            <div class="btn-group" role="group" aria-label="cookingmore">
              <button type="button" class="btn btn-default"><i class="fas fa-clock"></i> 10 minutes</button>
              <button type="button" class="btn btn-default"><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></button>
            </div>
          </div>
          <div class="col-md-3">
            <br><a href="#"><img class="img-fluid rounded receipe_first_img" src="assets/image/gratin2.jpg"></a>
            <h5 class="receipe_more_title"><a href="#">Gratin de courgette</a></h5>
            <div class="form-control text-center">
                <i class="far fa-thumbs-up fa-lg"></i> <span class="thumbs-number">[6]</span> &nbsp; &nbsp; <i class="far fa-thumbs-down fa-lg"></i> <span class="thumbs-number">[2]</span>
            </div>
            <div class="btn-group" role="group" aria-label="cookingmore">
              <button type="button" class="btn btn-default"><i class="fas fa-clock"></i> 45 minutes</button>
              <button type="button" class="btn btn-default"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></button>
            </div>
          </div>
          <div class="col-md-3">
            <br><a href="#"><img class="img-fluid rounded receipe_first_img" src="assets/image/salade2.jpg"></a>
            <h5 class="receipe_more_title"><a href="#">Salade de concombre au chèvre et olives</a></h5>
            <div class="form-control text-center">
                <i class="far fa-thumbs-up fa-lg"></i> <span class="thumbs-number">[14]</span> &nbsp; &nbsp; <i class="far fa-thumbs-down fa-lg"></i> <span class="thumbs-number">[8]</span>
            </div>
            <div class="btn-group" role="group" aria-label="cookingmore">
              <button type="button" class="btn btn-default"><i class="fas fa-clock"></i> 5 minutes</button>
              <button type="button" class="btn btn-default"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></button>
            </div>
          </div>
          <div class="col-md-3">
            <br><a href="#"><img class="img-fluid rounded receipe_first_img" src="assets/image/pates1.jpg"></a>
            <h5 class="receipe_more_title"><a href="#">Pâtes sauce Madère</a></h5>
            <div class="form-control text-center">
                <i class="far fa-thumbs-up fa-lg"></i> <span class="thumbs-number">[54]</span> &nbsp; &nbsp; <i class="far fa-thumbs-down fa-lg"></i> <span class="thumbs-number">[15]</span>
            </div>
            <div class="btn-group" role="group" aria-label="cookingmore">
              <button type="button" class="btn btn-default"><i class="fas fa-clock"></i> 20 minutes</button>
              <button type="button" class="btn btn-default"><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></button>
            </div>
          </div>

        </div>
      </div>
    </div>

    <!-- Footer -->
    <footer class="footer ">
        <div class="container">
          <div class="row">
            <div class="col-lg-6 h-100 text-center text-lg-left my-auto">
              <ul class="list-inline mb-2">
                <li class="list-inline-item">
                  <a href="#">About</a>
                </li>
                <li class="list-inline-item">&sdot;</li>
                <li class="list-inline-item">
                  <a href="#">Contact</a>
                </li>
                <li class="list-inline-item">&sdot;</li>
                <li class="list-inline-item">
                  <a href="#">Terms of Use</a>
                </li>
                <li class="list-inline-item">&sdot;</li>
                <li class="list-inline-item">
                  <a href="#">Privacy Policy</a>
                </li>
              </ul>
              <p class="text-muted small mb-4 mb-lg-0">&copy; Your Website 2018. All Rights Reserved.</p>
            </div>
            <div class="col-lg-6 h-100 text-center text-lg-right my-auto">
              <ul class="list-inline mb-0">
                <li class="list-inline-item mr-3">
                  <a href="#">
                    <i class="fab fa-facebook fa-2x fa-fw"></i>
                  </a>
                </li>
                <li class="list-inline-item mr-3">
                  <a href="#">
                    <i class="fab fa-twitter fa-2x fa-fw"></i>
                  </a>
                </li>
                <li class="list-inline-item">
                  <a href="#">
                    <i class="fab fa-instagram fa-2x fa-fw"></i>
                  </a>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </footer>
  
      <!-- Scroll to Top Button (Only visible on small and extra-small screen sizes) -->
      <div class="scroll-to-top d-lg-none position-fixed ">
        <a class="js-scroll-trigger d-block text-center text-white rounded" href="#page-top">
          <i class="fa fa-chevron-up"></i>
        </a>
      </div>

      <!-- Scripting -->
      <script src="assets/vendor/jquery/jquery.min.js"></script>
      <script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
      <script src="assets/js/plugins.js"></script>

	<!-- End Body -->
	</body>
</html>
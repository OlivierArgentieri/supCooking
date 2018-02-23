<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
                      <li class="upper-links"><a class="links" href="listeRecettes.html"> <i class="fas fa-tasks"></i> Toutes les recettes</a></li>
                      <li class="upper-links"><a class="links" href="#"> <i class="fas fa-random"></i> Recette aléatoire</a></li>
                      <li class="upper-links"><a class="links" href="/supCooking/auth/newRecipe"><i class="fas fa-pencil-alt"></i> Ecrire ma recette</a></li>
                      <!-- Moovers --><li class="up"></li>
                      <c:choose>
                      <c:when test="${messages['username']  != null }">
					        ${messages['username']}
					        <li class="upper-links"><a class="links" href="/supCooking/logout"><i class="fas fa-users"></i> D�connection</a></li>
					    </c:when>    
					    <c:otherwise>
					        <li class="upper-links"><a class="links" href="/supCooking/login.jsp"><i class="fas fa-users"></i> Connexion</a></li>
					        <br />
					    </c:otherwise>
					  </c:choose>
                  </ul>
                </div>
              </div>
              <div class="row row2 d-flex align-items-center">
                  <div class="col-sm-3">
                      <h2 style="margin:0px;"><span class="smallnav menu" onclick="openNav()">☰ <img class="img-fluid" src="assets/image/logo.png"></span></h2>
                      <h1 style="margin:0px;"><span class="largenav"><img class="img-fluid" src="assets/image/logo.png"></span></h1>
                  </div>
                  <div class="flipkart-navbar-search smallsearch col-sm-9 col-xs-12">
                      <div class="row">
                          <input id="search" class="flipkart-navbar-input col-sm-11 col-xs-10" placeholder="Qu'allez vous manger ce soir ? Un bon petit plat ? Une pizza ?" name="search">
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
          <a href="#">Ma recette</a>
          <a href="/supCooking/login.jsp">Connexion</a>
      </div>

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
                <p class="lead"><i>C'est ici que nous intervenons, G2Oeufs à été pensé pour vous permettre de partager vos recettes, votre envie de la bonne cuisine et aider votre prochain.
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
      <script type="text/javascript">
        function openNav() {
          document.getElementById("mySidenav").style.width = "70%";
          // document.getElementById("flipkart-navbar").style.width = "50%";
          document.body.style.backgroundColor = "rgba(0,0,0,0.4)";
        }

        function closeNav() {
          document.getElementById("mySidenav").style.width = "0";
          document.body.style.backgroundColor = "rgba(0,0,0,0)";
        }
      </script>

	<!-- End Body -->
	</body>
</html>
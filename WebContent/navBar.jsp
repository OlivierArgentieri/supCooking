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
									<li class="upper-links"><a class="links" href="#"> <i class="fas fa-random"></i> Recette aleatoire</a></li>
									<li class="upper-links"><a class="links" href="/supCooking/auth/newRecipe"><i class="fas fa-pencil-alt"></i> Ecrire ma recette</a></li>
									<!-- Moovers --><li class="up"></li>
									<c:choose>
									<c:when test="${messages['username']  != null }">
											<li class="upper-links"><a class="links" href="/supCooking/profile?id=${messages['id']}"><i class="fas fa-user"></i> ${messages['username']}</a></li>
											<li class="upper-links"><a class="links" href="logout"><i class="fas fa-logout"></i> Deconnexion</a></li>
									</c:when>    
									<c:otherwise>
											<li class="upper-links"><a class="links" href="login"><i class="fas fa-users"></i> Connexion</a></li>
											<br />
									</c:otherwise>
								</c:choose>
							</ul>
						</div>
					</div>
					<div class="row row2 d-flex align-items-center">
							<div class="col-sm-3">
									<h2 style="margin:0px;"><span class="smallnav menu" onclick="openNav()"><img class="img-fluid" src="assets/image/logo.png"></span></h2>
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
					<a href="javascript:void(0)" class="closebtn" onclick="closeNav()"></a>
			</div>
			<a href="#">Recettes</a>
			<a href="#">Aleatoire</a>
			<a href="#">Ma recette</a>
			<a href="/supCooking/login.jsp">Connexion</a>
	</div>
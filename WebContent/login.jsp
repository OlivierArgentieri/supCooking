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
      <link href="assets/css/login.css" rel="stylesheet">
  </head>
  <body>
      <div class="container">
          <div class="card card-container">
            <br>
            <a><img class="img-responsive" src="assets/image/logo.png"/></a>
            <hr>
            	<p>
            		<span class="error">${messages["user"]}</span>
        		</p>
            <form class="form-signin" method="POST" action="connexion">
                <span id="reauth-email" class="reauth-email"></span>
                <input type="text" name="username" id="inputPseudo" class="form-control" placeholder="Nom d'utilisateur" required autofocus>
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Mot de Passe" required>
                <div class="text-left mb-2">
					<div class="form-check">
					    <input type="checkbox" name="rmMe" id="inputRmMe" class="form-check-input">
					    <label class="form-check-label" for="inputRmMe">Se souvenir de moi</label>
					</div>    
                </div>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Connexion</button>
            	<a href="inscription"><br>Je ne possède pas de compte</a>
            </form>
          </div>
      </div>
  </body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="Website for manage recipe">
      <meta name="author" content="">
  
      <title>Nouvelles recettes</title>
  
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
            <img class="img-responsive" src="assets/image/logo.png">
            <hr>
            <form class="form-register" method="POST" action="newRecipe">
            	<p>
            		<span class="error">${messages["username"]}</span>
        		</p>
        		
                <input type="text" name="name" id="inputName" class="form-control"required>
                <input type="text" name="description" id="inputDescription" class="form-control" required>
                <input type="text" name="icon" id="inputIcon" class="form-control"required>
                <input type="text" name="cookingTime" id="inputCookingTime" class="form-control" required autofocus>
                <input type="text" name="difficulty" id="inputDifficulty" class="form-control" required>
                <input type="number" name="time" id="inputTime" class="form-control" required>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Valider</button>
            </form>
          </div>
      </div>      
  </body>
</html>

		
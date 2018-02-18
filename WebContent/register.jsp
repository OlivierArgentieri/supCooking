<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
  <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
      <meta name="description" content="Website for manage recipe">
      <meta name="author" content="">
  
      <title>SupCooking Register</title>
  
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
            <img class="img-responsive" src="assets/image/logo.png"></a>
            <hr>
            <form class="form-register" method="POST" action="Register">
                <input type="text" name="address" id="inputAddress" class="form-control" required autofocus>
                <input type="text" name="description" id="inputDescription" class="form-control" required>
                <input type="text" name="firstName" id="inputFirstName" class="form-control" required>
                <input type="text" name="lastName" id="inputLastName" class="form-control"required>
                <input type="text" name="mail" id="inputMail" class="form-control" required>
                
                <input type="password" name="password" id="inputPassword" class="form-control" placeholder="Mot de Passe" required>
                <input type="text" name="postCode" id="inputPostCode" class="form-control" required>
                <input type="text" name="phoneNumber" id="inputPhoneNumber" class="form-control" required>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Valider</button>
            </form>
          </div>
      </div>      
  </body>
</html>

		
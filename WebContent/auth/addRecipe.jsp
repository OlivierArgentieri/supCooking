<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.HashMap"%>
    
<% HashMap<String, String> messages = (HashMap<String, String>) request.getAttribute("messages"); %>
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
            <form class="form-register" method="POST" action="newRecipe" enctype='multipart/form-data'>
            	<p>
            	<% if (messages != null) { %>
            		 <%  for(String s : messages.values()){ %>
            		 <span class="error"><%=s %></span>
            		 <% }
            		 }%>
        		</p>
        		
                <input type="text" name="name" id="inputName" class="form-control" placeholder="inputName" required>
                <input type="file" name="file" id="inputImage" class="form-control"  required>
                <input type="text" name="description" id="inputDescription" class="form-control" placeholder="inputDescription" required>
                <input type="number" name="cookingTime" id="inputCookingTime" class="form-control" placeholder="inputCookingTime"  min="0"required autofocus>
                <input type="text" name="difficulty" id="inputDifficulty" class="form-control" placeholder="inputDifficulty" required>
                <input type="number" name="time" id="inputTime" class="form-control" placeholder="inputTime" required>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Valider</button>
            </form>
          </div>
      </div>      
  </body>
</html>
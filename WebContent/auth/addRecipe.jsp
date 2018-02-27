<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="java.util.HashMap"%>
<% HashMap<String, String> messages = (HashMap<String, String>) request.getAttribute("messages"); %>
<%@include file="header.jsp" %>
<%@include file="../navBar.jsp" %>

      <div class="container">
       <div class="row">
          <div class="col-sm-12 text-center">

            <h3 class="spacing_title">Ajouter une recette</h3>
 
          </div>
        </div>
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
                <input type="text" name="text" id="inputText" class="form-control" placeholder="inputText" required>
                <input type="number" name="cookingTime" id="inputCookingTime" class="form-control" placeholder="inputCookingTime"  min="0" required>
                <input type="number" name="difficulty" id="inputDifficulty" class="form-control" placeholder="inputDifficulty"  min="1"  max="5" required>
                <input type="number" name="time" id="inputTime" class="form-control" placeholder="inputTime"  min="0"required>
                
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Valider</button>
            </form>
          </div>
      </div>      
<%@ include file="../footer.jsp" %>
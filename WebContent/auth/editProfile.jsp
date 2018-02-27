<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.supinfo.supcooking.entity.User"%>
<% User u = (User) request.getAttribute("user"); %>


<%@ include file="../navBar.jsp" %>
<%@ include file="header.jsp" %>
      <div class="container">
          <div class="card card-container">
            <br>
            <img class="img-responsive" src="assets/image/logo.png">
            <hr>
            <form class="form-register" method="POST" action="editProfile">
            	<p>
            		<span class="error">${messages["username"]}</span>
        		</p>
        		<input type="text" name="username" id="inputUsername" class="form-control" placeholder="Pseudonyme" value="<%=u.getUsername()%> "required autofocus>
                <br><input type="text" name="mail" id="inputMail" class="form-control" placeholder="Adresse Email" value="<%=u.getMail()%>" required>
                <br><input type="password" name="password" id="inputPassword" class="form-control" placeholder="Mot de Passe" required>
                <br><input type="text" name="firstName" id="inputFirstName" class="form-control" placeholder="Prenom" value="<%=u.getFirstName()%>"required>
                <br><input type="text" name="lastName" id="inputLastName" class="form-control" placeholder="Nom" value="<%=u.getLastName()%>"required>
                <br><input type="text" name="address" id="inputAddress" class="form-control" placeholder="Adresse" value="<%=u.getAddress()%>"required>
                <br><input type="text" name="postCode" id="inputPostCode" class="form-control" placeholder="Code Postal" value="<%=u.getPostCode()%>"required>
                <br><input type="text" name="phoneNumber" id="inputPhoneNumber" class="form-control" placeholder="Telephone" value="<%=u.getPhoneNumber()%>"required>
                <br><textarea rows="4" type="text" name="description" id="inputDescription" class="form-control" placeholder="Description" value="<%=u.getDescription()%>"required></textarea>
                <br>
                <button class="btn btn-lg btn-primary btn-block btn-signin" type="submit">Valider</button>
            </form>
          </div>
      </div>      
<%@ include file="../footer.jsp" %>
		
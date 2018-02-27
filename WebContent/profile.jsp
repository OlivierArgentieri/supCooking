<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.supinfo.supcooking.entity.User"%>
<%@page import="com.supinfo.supcooking.entity.Recipe"%>
<%@page import="java.util.List"%>
<% User u = (User) request.getAttribute("user"); %>
<% List<Recipe> mesRecettes =u.getRecipes(); %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
	<%@ include file="header.jsp" %>
	<%@ include file="navBar.jsp" %>

    <!-- profil -->
    <div class="container">
      <div class="receipe_detail">
        <div class="row">
          <div class="col-sm-12 text-center">
            <hr>
            <h3 class="spacing_title">Profil de  <p><%=u.getUsername() %></p></h3>

           
				
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
              <h3 class="spacing_title">Recettes écrites par <%=u.getUsername() %></h3>
              <hr>
            </div>
          
           <%	if(mesRecettes != null){
            
					   for(Recipe r : mesRecettes) { %>
					   
          <div class="col-md-3">
            <br><a href="#"><img class="img-fluid rounded receipe_first_img" src="images/<%=r.getImage() %>"></a>
            <h5 class="receipe_more_title"><a href="#"><%=r.getName() %></a></h5>
            <div class="form-control text-center">
                <i class="far fa-thumbs-up fa-lg"></i> <span class="thumbs-number">[10]</span> &nbsp; &nbsp; <i class="far fa-thumbs-down fa-lg"></i> <span class="thumbs-number">[5]</span>
            </div>
            <div class="btn-group" role="group" aria-label="cookingmore">
              <button type="button" class="btn btn-default"><i class="fas fa-clock"></i><%=r.getTime().getMinutes() + r.getCookingTime().getMinutes() %> minutes</button>
              <button type="button" class="btn btn-default"><i class="fas fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i><i class="far fa-star"></i></button>
            </div>
          
          </div>
          <% } %>
         <% } else {%>
        	 <%=u.getUsername() %> n'a pas encore écris de recettes
        <% }%>
        
        
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
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>

	<%
		HttpSession objsesion = request.getSession(false);
		String usuario = (String)objsesion.getAttribute("usuario");
// 		if(usuario==null){
// 			response.sendRedirect("index.jsp");
			 
// 		}   
	%> 


<html>
<head>
<meta charset="ISO-8859-1">
<title>Carrito</title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body>

 <jsp:include page="header.jsp" /> 
<div class="container-fluid">
	<jsp:include page="login.jsp" /> 
	<div class="container" style="padding:10px">
	<h2>${debesLogearte}</h2>
		<div class="row">
	            <c:forEach var="p" items="${productos}">
	            	<div class="col-sm-3">
	             	<div class="card">
	             	  <div style="height: 150px;margin: 0 auto;padding:10px">
					  	<img class="card-img-top" style="max-width:100px;height:auto;" src="ControladorIMG?id=${p.getId()}" height="100" width="100">
	             	  </div>
					  <div class="card-body">
					    <h5 class="card-title">${p.getNombre()}</h5>
					    <p class="card-text">$ ${p.getPrecio()}</p>
					    <%---<p class="card-text">${p.getDescripcion()}</p>--%>
					     <%---<a role="button"  class="btn btn-primary" href="edit?accion=AgregarCarrito&id=${p.getId()}&cantidad=1&continua=no">Agregar a carrito</a>--%>
	                     <form action="edit?accion=AgregarCarrito" method="post">
	                     	<input type="hidden" value="${p.getId()}" name="id">
	                     	<input type="hidden" value="1" name="cantidad">
	                     	<input type="hidden" value="no" name="continua">
	                     	<button type="Submit" class="btn btn-primary myAnchor">Agregar a carrito</button>	                     
	                     </form>
	                     <form action="edit?accion=Comprar" method="post">
	                     	<input type="hidden" value="${p.getId()}" name="id">
	                     	<input type="hidden" value="1" name="cantidad">
	                     	<input type="hidden" value="si" name="continua">
	                     	<button type="Submit" class="btn btn-danger">Comprar ahora</button>	                     
	                     </form>
					  </div>
					</div>
				</div>
	            </c:forEach>                    
		</div>
	</div>
</div>
        <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	<script src="js/funciones.js" type="text/javascript"></script>
</body>
</html>
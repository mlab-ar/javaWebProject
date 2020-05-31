<%@page import="entidades.Producto"%>
<%@page import="baseDeDatos.ProductoDAO"%>
<%@page import="interfaces.I_ProductosRepo" %>
<%@page import="java.util.ArrayList"%>
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

<% 
	I_ProductosRepo pdao = new ProductoDAO();
	ArrayList<Producto>productos=new ArrayList<>();
	productos=(ArrayList<Producto>) pdao.listar();
 	request.setAttribute("productos", productos);
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
	<div class="container" style="padding:10px">
 		<div class="row">
	            <c:forEach var="p" items="${productos}">
	            	<div class="col-sm-3" style="margin-bottom:20px;">
	             	   
	             	<div class="card">
	             		
	             	  <div style="height: 150px;margin: 0 auto;padding:10px">
					  	<img class="card-img-top" style="max-width:100px;height:auto;" src="ControladorIMG?id=${p.getId()}" height="100" width="100">
	             	  </div>
	             	   
					  <div class="card-body">
					    <h5 class="card-title">${p.getNombre()}</h5>
					    <p class="card-text">$ ${p.getPrecio()}</p>
					    <%---<p class="card-text">${p.getDescripcion()}</p>--%>
					     <%---<a role="button"  class="btn btn-primary" href="edit?accion=AgregarCarrito&id=${p.getId()}&cantidad=1&continua=no">Agregar a carrito</a>--%>
	                    
<!-- 	                     <form action="edit?accion=Comprar" method="post"> -->
<%-- 	                     	<input type="hidden" value="${p.getId()}" name="id"> --%>
<!-- 	                     	<input type="hidden" value="1" name="cantidad"> -->
<!-- 	                     	<input type="hidden" value="si" name="continua"> -->
<!-- 	                     	<button type="Submit" class="btn btn-danger">Comprar ahora</button>	                      -->
<!-- 	                     </form> -->
	                      <form action="edit?accion=AgregarCarrito" method="post" style="display:inline-block;">
	                     	<input type="hidden" value="${p.getId()}" name="id">
	                     	<input type="hidden" value="1" name="cantidad">
	                     	<input type="hidden" value="no" name="continua">
	                     	    <button type="Submit" class="btn btn-success myAnchor" style="width: 50px;padding: 4px 7px 7px 7px;">
		                     		<svg class="bi bi-cart-plus" width="1.2em" height="1.2em" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
									  <path fill-rule="evenodd" d="M8.5 5a.5.5 0 0 1 .5.5v2a.5.5 0 0 1-.5.5h-2a.5.5 0 0 1 0-1H8V5.5a.5.5 0 0 1 .5-.5z"/>
									  <path fill-rule="evenodd" d="M8 7.5a.5.5 0 0 1 .5-.5h2a.5.5 0 0 1 0 1H9v1.5a.5.5 0 0 1-1 0v-2z"/>
									  <path fill-rule="evenodd" d="M0 1.5A.5.5 0 0 1 .5 1H2a.5.5 0 0 1 .485.379L2.89 3H14.5a.5.5 0 0 1 .491.592l-1.5 8A.5.5 0 0 1 13 12H4a.5.5 0 0 1-.491-.408L2.01 3.607 1.61 2H.5a.5.5 0 0 1-.5-.5zM3.102 4l1.313 7h8.17l1.313-7H3.102zM5 12a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm7 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4zm-7 1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm7 0a1 1 0 1 0 0 2 1 1 0 0 0 0-2z"/>
									</svg>
		                     	</button>              
	                     </form>
	                     <button role="button"  class="btn btn-primary" href="detalle?accion=Mostrar&id=${p.getId()}">Ver más</button>
	                    
					  </div>
					</div>
				</div>
	            </c:forEach>                    
		</div>
	</div>
</div>
	<jsp:include page="login.jsp" /> 
	
	<jsp:include page="registro.jsp" />
        <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
	<script src="js/funciones.js" type="text/javascript"></script>
	
	<script>
		var showModal = '${debesLogearte}';
		$('#loginModal').modal(showModal);
	</script>
</body>
</html>
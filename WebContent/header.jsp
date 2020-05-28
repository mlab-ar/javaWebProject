<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	HttpSession objsesion = request.getSession(false);
	String usuario = (String)objsesion.getAttribute("usuario");
	String test = (String)objsesion.getAttribute("test");
	//int clienteId = (int)objsesion.getAttribute("clienteId");
	if(usuario == null){
		response.sendRedirect("index.jsp");
	}
	 
%>
    <header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
			    <span class="navbar-toggler-icon"></span>
			  </button>
			  <div class="collapse navbar-collapse" id="navbarTogglerDemo01">
			    <a class="navbar-brand" href="#"></a>
			    <ul class="navbar-nav mr-auto mt-2 mt-lg-0">
			      <li class="nav-item">
			        <a class="nav-link" href="Controlador?accion=home">Home</a>            
			      </li>
			      <li class="nav-item">
			        <a class="nav-link" href="edit?accion=Carrito">(<label class="misProd">${contador2}</label>)Carrito</a>
			      </li>
			       
			    </ul>
			    <form class="form-inline my-2 my-lg-0">
			      <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
			      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
			    </form>
			    <%if(usuario!=null){ %>
				    <div class="btn-group">
					  <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
					    Menu
					  </button>
					  <div class="dropdown-menu dropdown-menu-right">
					  	 
					    <button class="dropdown-item" type="button"><% out.print(usuario); %></button>
					    <a class="dropdown-item" href="Inicio?accion=Salir">Salir</a>
					  	 
					  </div>
					</div>
				  	<%}else{%>
				  	<ul class="navbar-nav ">
			      		<li class="nav-item">
				  			<a href="#"  class="nav-link" data-toggle="modal" data-target="#exampleModal">Ingresar</a>
				  		</li>
				  	</ul>
				  <%} %>
			  </div>
			</nav>
	</header>
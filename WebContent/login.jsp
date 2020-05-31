<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <!-- Modal -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
	        <h5 class="modal-title" id="exampleModalLabel">Login</h5>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	          <span aria-hidden="true">&times;</span>
	        </button>
	      </div>
 	       <h6 class="modal-title" style="text-align: center;padding: 4px 10px;color:red;">${debesLogearteText}</h6> 
       <div class="modal-body">
        <div style="max-width:600px;margin:0 auto;">
		<form action="Inicio">
		  <div class="form-group">
		    <label for="exampleInputEmail1">Email</label>
		    <input type="email" name="txtEmail" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="password" name="password" class="form-control" id="exampleInputPassword1">
		  </div>
		  <button type="submit" class="btn btn-primary" name="accion" value="Iniciar Sesión">Enviar</button>
		</form>
		<a href="#" data-dismiss="modal" class="nav-link" data-toggle="modal" data-target="#registroModal" aria-label="Close">Registrarme</a>
  </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
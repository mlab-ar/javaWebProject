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
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
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
		<a href="registro.jsp">Registrarme</a>
  </div>
      </div>
    </div>
  </div>
</div>
</body>
</html>
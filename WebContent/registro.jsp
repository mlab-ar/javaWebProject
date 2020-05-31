<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    

<script>
/**window.history.pushState({}, document.title, "/webProject2/registro.jsp");**/
</script>
	 

<div class="modal fade" id="registroModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalRegistro" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalRegistro">Registro</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <div style="max-width:600px;margin:0 auto;">
		<form action="registro">
		<div class="form-group">
		    <label for="exampleInputName">Name</label>
		    <input type="text" name="nombre" class="form-control" id="exampleInputName" aria-describedby="nameHelp">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputLastName">Apellido</label>
		    <input type="text" name="apellido" class="form-control" id="exampleInputLastName" aria-describedby="emailHelp">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputDni">DNI</label>
		    <input type="text" name="dni" class="form-control" id="exampleInputDni" aria-describedby="emailHelp">
		  </div>
		   <div class="form-group">
		    <label for="exampleInputEmail1">Email</label>
		    <input type="text" name="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
		  </div>
		  <div class="form-group">
		    <label for="exampleInputPassword1">Password</label>
		    <input type="text" name="pass"  class="form-control" id="exampleInputPassword1">
		  </div>
		  <button type="submit" class="btn btn-primary">Enviar</button>
		</form>
  		</div>
      </div>
    </div>
  </div>
</div>


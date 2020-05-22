package excepciones;

public class UsuarioException extends Exception{
	private String mensaje;

	public UsuarioException(String mensaje) {
		this.mensaje = mensaje;
	}
	
	public String getMassage() {
		return mensaje;
	}
}

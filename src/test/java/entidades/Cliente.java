package entidades;

public class Cliente extends Persona {
	

	public Cliente() {
		
	}

	
	public Cliente(int id, String dni, String nombre, String email, String password, Domicilio domicilio) {
		super(id, dni, nombre, email, password, domicilio);
		setId(id);
		setDni(dni);
		setNombre(nombre);
		setEmail(email);
		setPassword(password);
		setDomicilio(domicilio);
	}


	@Override
	public String toString() {
		return "Cliente [getDni()=" + getDni() + ", hashCode()=" + hashCode() + ", getId()=" + getId()
				+ ", getNombre()=" + getNombre() + ", getEmail()=" + getEmail() + ", getPassword()=" + getPassword()
				+ ", getDomicilio()=" + getDomicilio() + ", getClass()=" + getClass() + ", toString()="
				+ super.toString() + "]";
	}
	


	
}



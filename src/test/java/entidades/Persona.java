package entidades;

import utils.StringUtils;

public abstract class Persona {
	private int id;
	private String nombre;
	private String apellido;
	private String email;
	//private Domicilio domicilio;
	
	
	public Persona() {
		
	}


	
	public Persona(String nombre, String apellido, String email) {
		setNombre(nombre);
		setApellido(apellido);
		setEmail(email);
	}

	@Override
	public boolean equals(Object obj) {
		Persona p = (Persona) obj;
		return this.nombre.equals(p.getNombre());
	}
	
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return 1;
	}

	
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + "]";
	}



	public String getNombreCompleto() {
		return StringUtils.wordToCamelCase(nombre) + " " + StringUtils.wordToCamelCase(apellido);
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}


	
	
	
	
	
	
}

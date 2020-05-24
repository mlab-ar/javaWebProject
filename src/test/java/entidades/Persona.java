package entidades;

import utils.StringUtils;

public abstract class Persona {
	private int id;
	private String dni;
	private String nombre;
	private String email;
	private String password;
	private Domicilio domicilio;
	
	
	public Persona() {
		
	}


	
	
	public Persona(int id,String dni, String nombre, String email, String password, Domicilio domicilio) {
		setId(id);
		setDni(dni);
		setNombre(nombre);
		setEmail(email);
		setPassword(password);
		setDomicilio(domicilio);
		
	}




	public String getDni() {
		return dni;
	}




	public void setDni(String dni) {
		this.dni = dni;
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



	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public Domicilio getDomicilio() {
		return domicilio;
	}




	public void setDomicilio(Domicilio domicilio) {
		this.domicilio = domicilio;
	}




	 

	
	
	
}

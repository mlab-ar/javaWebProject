package entidades;

public class Cliente extends Persona {
	//private int numeroCliente;

	public Cliente() {
		
	}

	public Cliente(String nombre, String apellido, String email) {
		super(nombre, apellido, email);
		// TODO Auto-generated constructor stub
		//this.numeroCliente = numeroCliente;
	}

	@Override
	public String toString() {
		return "Cliente [hashCode()=" + hashCode() + ", toString()=" + super.toString() + ", getNombreCompleto()="
				+ getNombreCompleto() + ", getId()=" + getId() + ", getNombre()=" + getNombre() + ", getApellido()="
				+ getApellido() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + "]";
	}

//	@Override
//	public String toString() {
//		return super.toString() + " " + "numeroCliente" + numeroCliente;
//	}
//
//	public int getNumeroCliente() {
//		return numeroCliente;
//	}
//
//	public void setNumeroCliente(int numeroCliente) {
//		this.numeroCliente = numeroCliente;
//	}
	
	
}



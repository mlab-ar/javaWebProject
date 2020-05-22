package entidades;

public class Domicilio {
	private int numero;
	private String calle;
	private String localidad;
	
	
	public Domicilio() {
		
	}
	
	
	
	public Domicilio(int numero, String calle, String localidad) {
		this.numero = numero;
		this.calle = calle;
		this.localidad = localidad;
	}



	@Override
	public String toString() {
		return "Domicilio [numero=" + numero + ", calle=" + calle + ", localidad=" + localidad + "]";
	}



	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	
	
	
}

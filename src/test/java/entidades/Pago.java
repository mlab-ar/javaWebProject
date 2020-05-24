package entidades;

public class Pago {
	private int id;
	private Double monto;
	
	
	public Pago() {
		// TODO Auto-generated constructor stub
	}


	public Pago(int id, Double monto) {
		this.id = id;
		this.monto = monto;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Double getMonto() {
		return monto;
	}


	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
}

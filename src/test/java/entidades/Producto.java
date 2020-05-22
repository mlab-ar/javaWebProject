package entidades;

import java.awt.Image;
import java.io.InputStream;

import com.mysql.jdbc.Blob;

public class Producto {
	private int id;
	private String nombre;
	private String descripcion;
	private Double precio;
	private InputStream foto;
	private int stock;
 
	public Producto() {
	}

	public Producto(int id, String nombre, String descripcion, Double precio, InputStream foto, int stock) {
		this.id = id;
		this.precio = precio;
		this.descripcion = descripcion;
		this.nombre = nombre;
		this.foto = foto;
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", foto=" + foto + ", stock=" + stock + "]";
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

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public InputStream getFoto() {
		return foto;
	}

	public void setFoto(InputStream foto) {
		this.foto = foto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}
	
	 
	

}


package es.codeurjc.helloworldspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String Producto;
	private int Precio;
	private String valoracion;

	public Productos() {}

	public Productos(String Producto, int precio, String valoracion) {
		this.Producto = Producto;
		this.Precio = precio;
		this.valoracion = valoracion;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProducto() {
		return Producto;
	}

	public void setProducto(String producto) {
		Producto = producto;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public String toString() {
		return "Producto [Producto=" + Producto + ", Precio=" + Precio + ", valoracion=" + valoracion + "]";
	}
	
	
}

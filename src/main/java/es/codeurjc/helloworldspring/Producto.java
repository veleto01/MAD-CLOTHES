package es.codeurjc.helloworldspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String nombre;

	private String codigo;

	private int precio;

	private int unidades;
	
	@OneToOne
	private Oferta oferta;

	public Producto(String nombre, String codigo, int precio, int id, int unidades) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.id = id;
		this.unidades = unidades;
	}

	public Producto(String nombre, String codigo, int precio, int id) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.id = id;
	}

	public Producto() {
	}

	public int getUnidades() {
		return unidades;
	}

	public void setUnidades(int unidades) {
		this.unidades = unidades;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public int getPrecio() {
		return precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}


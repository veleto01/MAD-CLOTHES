package madclothes.entidades;

import javax.persistence.Column;
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
	
	@Column(name = "codigo", length = 100, unique = true)
	private int codigo;

	private int precio;

	private int unidades;
	
	@OneToOne
	private Oferta oferta;

	public Producto(String nombre, int codigo, int precio, int id, int unidades) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.id = id;
		this.unidades = unidades;
	}

	public Producto(String nombre, int codigo, int precio, int unidades) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
		this.unidades = unidades;
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

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
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

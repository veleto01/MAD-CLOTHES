package madclothes.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
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
	private int precioInicial;
	


	private int unidades;
	
	
	private double oferta_Aplicada;
	
	@ManyToOne
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

	public double getOferta_Aplicada() {
		return oferta_Aplicada;
	}

	public void setOferta_Aplicada(double oferta_Aplicada) {
		this.oferta_Aplicada = oferta_Aplicada;
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

	public Oferta getOferta() {
		return oferta;
	}

	public void setOferta(Oferta oferta) {
		this.oferta = oferta;
	}

	
	

	public int getPrecioInicial() {
		return precioInicial;
	}

	public void setPrecioInicial(int precioInicial) {
		this.precioInicial = precioInicial;
	}
	 
	
}

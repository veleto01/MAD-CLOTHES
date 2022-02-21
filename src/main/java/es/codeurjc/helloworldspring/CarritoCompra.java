package es.codeurjc.helloworldspring;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.springframework.data.annotation.Id;
@Entity
public class CarritoCompra {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToOne
	private Usuario usuario;
	@OneToMany
	private static List<Producto> listaProductos;

	public CarritoCompra() {
		
	}
	public CarritoCompra(Usuario u){
		this.usuario=u;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public static List<Producto> getListaProductos() {
		return listaProductos;
	}
	public static void setListaProductos(List<Producto> lista) {
		listaProductos = lista;
	}
	@Override
	public String toString() {
		return "CarritoCompra [Usuario=" + usuario + ", listaProductos=" + listaProductos + "]";
	}
	
}

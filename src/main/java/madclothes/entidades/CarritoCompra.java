package madclothes.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CarritoCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private Usuario usuario;
	
	@OneToMany
	
	private static List<Producto> listaProductos; 


	public CarritoCompra() {
		
	}
	//POR DEFECTO CUANDO ENCIENDES LA PAGINA
	public CarritoCompra(Usuario u){
		this.usuario=u;
		listaProductos = new ArrayList<>();
	}
	//FILTRADO POR USUARIO METIENDO UN PRODUCTO EN LA LISTA DEL CARRITO
	public CarritoCompra(Usuario u,Producto x){
		this.usuario=u;
		listaProductos = new ArrayList<>();
		listaProductos.add(x);
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
	public static void setListaProductos(List<Producto> listaProductos) {
		CarritoCompra.listaProductos = listaProductos;
	}
	@Override
	public String toString() {
		return "CarritoCompra [Usuario=" + usuario + ", Producto=" + listaProductos + "]";
	}

	
}

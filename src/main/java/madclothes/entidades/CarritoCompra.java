package madclothes.entidades;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import javax.persistence.Id;

@Entity
public class CarritoCompra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@OneToOne
	private WebUser usuario;
	
	@OneToMany
	private  List<Producto> listaProductos; 


	public CarritoCompra() {
		
	}
	//POR DEFECTO CUANDO ENCIENDES LA PAGINA
	public CarritoCompra(WebUser u){
		this.usuario=u;
		this.listaProductos = new ArrayList<>();
	}
	//FILTRADO POR USUARIO METIENDO UN PRODUCTO EN LA LISTA DEL CARRITO
	public CarritoCompra(WebUser u,Producto x){
		this.usuario=u;
		this.listaProductos = new ArrayList<>();
		this.listaProductos.add(x);
	}
	
	
	
	public WebUser getUsuario() {
		return usuario;
	}
	public void setUsuario(WebUser usuario) {
		this.usuario = usuario;
	}
	

	public  List<Producto> getListaProductos() {
		return listaProductos;
	}

	
	public void setListaProductos(List<Producto> listaProductos) {
		this.listaProductos = listaProductos;
	}
	
	@Override
	public String toString() {
		return "CarritoCompra [Usuario=" + usuario + ", Producto=" + listaProductos + "]";
	}

	
}

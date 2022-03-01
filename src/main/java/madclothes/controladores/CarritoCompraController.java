package madclothes.controladores;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import madclothes.entidades.*;
import madclothes.repositorio.*;


public class CarritoCompraController {

	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private CarritoCompraRepository carritoRepository;	
	@Autowired
	private UsuarioRepository usuarioRepository;	
	
	CarritoCompra CarritoCompra;
	Usuario Usuario;
	Producto productoaux;
	
	@GetMapping("/verCarrito")
	public String verCarrito(Model model) {
		return "verCarrito";
	}

	@GetMapping("/verCarrito")
	public String verCarrito1(Model model) {
		double precio = 0;
		model.addAttribute("Productos", CarritoCompra.getListaProductos());
		for (Producto producto : CarritoCompra.getListaProductos()) {
		model.addAttribute("Producto", producto);
			precio += producto.getPrecio();
		}
		model.addAttribute("Precio Total", precio);
		return "/bienvenida";
	}


	/*@GetMapping("/CarritoCompra/Borrar")
	public String borrarCarrito(Model model) {
		for (Producto producto : CarritoCompra.getListaProductos()) {
			
			CarritoCompra.getListaProductos().remove(producto);		
		}
		return"CarritoCompra";
	}*/
	

	@GetMapping("/borrarProductoCarrito")
	public String borrarProductoCarrito(Model model) {
		return "borrarProductoCarrito";
	}
	
	@PostMapping("/borrarProductoCarrito")
	public String borrarPorducto(Model model,@RequestParam int codigo) {
		for (Producto producto : CarritoCompra.getListaProductos()) {
			if(producto.getCodigo()==codigo) {				
				CarritoCompra.getListaProductos().remove(producto);	
			}
		}
		return"/bienvenida";
	}
	
	
	
	
	@GetMapping("/agregarProductosCarrito")
	public String agregarProductosCarrito(Model model) {
		return "/agregarProductosCarrito";
	}
	
	@PostMapping("/anadirProducto")
	public String añadirProducto(Model model,@RequestParam int telefono,@RequestParam int codigo) {
		
		productoaux = productoRepository.findByCodigo(codigo);
		Usuario=usuarioRepository.findByTelefono(telefono);
		
		if(carritoRepository.findByUsuario(telefono)==null){
		carritoRepository.save(new CarritoCompra(Usuario,productoaux));
		}else {
			CarritoCompra.getListaProductos().add(productoaux);
		}
		return"/bienvenida";
		
	}
	
	
}

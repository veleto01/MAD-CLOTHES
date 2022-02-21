package es.codeurjc.helloworldspring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CarritoCompraController {
	@Autowired
	CarritoCompraRepository carritoRepository;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	ProductoRepository productoRepository;

	@GetMapping("/CarritoCompra")
	public String verCarrito(Model model) {
		double precio = 0;
		model.addAttribute("Productos", CarritoCompra.getListaProductos());
		for (Producto producto : CarritoCompra.getListaProductos()) {
			model.addAttribute("Producto", producto);
			precio += producto.getPrecio();
		}
		model.addAttribute("Precio Total", precio);
		return "CarritoCompra";
	}

	@GetMapping("/CarritoCompra/Borrar")
	public String borrarCarrito(Model model) {
		for (Producto producto : CarritoCompra.getListaProductos()) {
			model.addAttribute("Producto borrado", producto);
			CarritoCompra.getListaProductos().remove(producto);		
		}
		return"CarritoCompra";
	}
	
	@GetMapping("/CarritoCompra/Borrar/{idProducto}")
	public String borrarPorducto(@PathVariable long idProducto,Model model) {
		for (Producto producto : CarritoCompra.getListaProductos()) {
			if(producto.getId()==idProducto) {
				model.addAttribute("Producto borrado", producto);
				CarritoCompra.getListaProductos().remove(producto);	
			}
		}
		return"CarritoCompra";
	}
	
	@GetMapping("/CarritoCompra/Añadir/")
	public String añadirProducto(Model model,String codigo) {
		Producto proTemp = productoRepository.findByCodigo(codigo);
		CarritoCompra.getListaProductos().add(proTemp);
		model.addAttribute("Producto añadido", proTemp);
		return"CarritoCompra";
		
		
	}
}

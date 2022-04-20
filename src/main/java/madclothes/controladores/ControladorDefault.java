package madclothes.controladores;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import madclothes.entidades.CarritoCompra;
import madclothes.entidades.Producto;
import madclothes.entidades.WebUser;
import madclothes.repositorio.CarritoCompraRepository;
import madclothes.repositorio.ProductoRepository;
import madclothes.repositorio.WebUserRepository;

@Controller
public class ControladorDefault {
	@Autowired
	private ProductoRepository productoRepository;
	@Autowired
	private CarritoCompraRepository carritoRepository;	
	@Autowired
	private WebUserRepository usuarioRepository;	
	
	CarritoCompra CarritoCompra;
	WebUser Usuario;
	Producto productoaux;
	/*
	@GetMapping("/")
	public String bienvenida(Model model) {
		model.addAttribute("name", "MADCLOTHES");
		
		return "bienvenida";
	}*/

	@GetMapping("/AtencionCliente")
	public String atencionAlCliente(Model model) {
		model.addAttribute("name", "fwdf");
		
		return "AtencionCliente";
	}
	
	@GetMapping("/gestionProductos")
	public String gestionProdcutos(Model model) {
		model.addAttribute("name", "fwdf");
		
		return "gestionProductos";
	}
	
	@GetMapping("/CarritoCompra")
	public String CarritoCompra(Model model) {
		model.addAttribute("name", "fwdf");
		
		return "CarritoCompra";
	}
	
	@GetMapping("/gestionOferta")
	public String gestionOferta(Model model) {
		
		return "gestionOferta";
	}
	
	
	
	
	@GetMapping("/gestionUsuario")
	public String gestionUsuario(Model model) {
		model.addAttribute("name", "fwdf");
		
		return "gestionUsuario";
	}
	
	@GetMapping("/borrarProductoCarrito")
	public String borrarProductoCarrito(Model model) {
		return "borrarProductoCarrito";
	}
	@GetMapping("/agregarProductosCarrito")
	public String agregarProductosCarrito(Model model) {
		return "agregarProductosCarrito";
	}
	@GetMapping("/verCarrito")
	public String verCarrito(Model model) {
		return "verCarrito";
	}

	
	
	@PostMapping("/borrarProductoCarrito")
	public String borrarProductoCarrito(Model model,@RequestParam int telefono,@RequestParam int codigo) {
		
						
		carritoRepository.findByUsuarioTelefono(telefono).getListaProductos().remove(productoRepository.findByCodigo(codigo));	
		carritoRepository.save(carritoRepository.findByUsuarioTelefono(telefono));
			
		
		return"/bienvenida";
	}
	
	
	
	@PostMapping("/anadirProducto")
	public String anadirProducto(Model model,@RequestParam int telefono,@RequestParam int codigo) {
		productoaux = productoRepository.findByCodigo(codigo);
		
		Usuario=usuarioRepository.findByTelefono(telefono);
		
		if(carritoRepository.findByUsuarioTelefono(telefono)==null){
		carritoRepository.save(new CarritoCompra(Usuario,productoaux));
		}else {
			
			
			
			carritoRepository.findByUsuarioTelefono(telefono).getListaProductos().add(productoaux);
			
			carritoRepository.save(carritoRepository.findByUsuarioTelefono(telefono));
		}
		return"/bienvenida";
		
	}
}

package madclothes.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorDefault {
	
	
	@GetMapping("/")
	public String bienvenida(Model model) {
		model.addAttribute("name", "MADCLOTHES");
		
		return "bienvenida";
	}

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
}

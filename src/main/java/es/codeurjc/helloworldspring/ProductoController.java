package es.codeurjc.helloworldspring;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;



@Controller
@RequestMapping(path = "/productos")
public class ProductoController {

	@Autowired
	private ProductoRepository RepositorioProductos;
	
	@Autowired
	private ProductoOfertaRepository RepositoryOferta;

	@PostConstruct
	public void init() {
		RepositorioProductos.save(new Producto( "Camiseta Nike" , "ASDFG" ,20 , 1 , 10 ));
		
		RepositorioProductos.save(new Producto("Sudadera ADIDAS","BASNDJ",50,2,10));
		
		RepositoryOferta.save(new Oferta(0.5));
		
		
	}
	
	
	
	@GetMapping(value = "/crearProducto")
	public String crearProducto(Model model) {
		model.addAttribute("producto", new Producto());
		return "productos/agregar_producto";
	}

	@GetMapping(value = "/mostrar")
	public String mostrarProductos(Model model) {
		model.addAttribute("productos", RepositorioProductos.findAll());
		return "productos/ver_productos";
	}

	@PostMapping(value = "/eliminar")
	public String eliminarProducto(@ModelAttribute Producto producto, RedirectAttributes redirectAttrs) {

		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente");

		RepositorioProductos.deleteById(producto.getId());
		return "redirect:/productos/mostrar";
	}

	@PostMapping(value = "/agregar")
	public String guardarProducto(@ModelAttribute Producto producto) {
		
		if (RepositorioProductos.findByCodigo(producto.getCodigo()) != null) {
			return "redirect:/productos/agregar";
		}
		RepositorioProductos.save(producto);

		return "redirect:/productos/agregar";
	}
	
	
	//PRODUCTOS CON OFERTA
	
	@Autowired
	private ProductoOfertaRepository RepositorioProductosOferta;
	
	@GetMapping(value = "/mostrarOferta")
	public String mostrarProductosOferta(Model model) {
		model.addAttribute("oferta", RepositorioProductosOferta.findAll());
		return "productos/ver_productosOferta";
	}
	
	@GetMapping(value = "/crearOferta")
	public String crearOferta(Model model) {
		model.addAttribute("oferta", new Oferta());
		return "productos/agregar_producto";
	}

	@PostMapping(value = "/eliminarOferta")
	public String eliminarOferta(@ModelAttribute Oferta oferta, RedirectAttributes redirectAttrs) {

		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente");

		RepositorioProductosOferta.deleteById(oferta.getId());
		return "redirect:/productos/mostrarOferta";
	}
	/*
	@PostMapping(value = "/agregarOferta")
	public String guardarOferta(@ModelAttribute Oferta oferta) {
		
		if (RepositorioProductosOferta.findByDescuento(oferta.getDescuento()) != null) {
			return "redirect:/productos/agregarOferta";
		}
		RepositorioProductosOferta.save(oferta);

		return "redirect:/productos/agregarOferta";
	}*/
	
}


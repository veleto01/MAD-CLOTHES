package madclothes.controladores;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import madclothes.entidades.Oferta;
import madclothes.entidades.Producto;
import madclothes.entidades.Usuario;
import madclothes.repositorio.ProductoOfertaRepository;
import madclothes.repositorio.ProductoRepository;
import madclothes.repositorio.UsuarioRepository;
import madclothes.controladores.*;

@Controller
public class ProductoController {

	@Autowired
	private ProductoRepository RepositorioProductos;

	@Autowired
	private ProductoOfertaRepository RepositoryOferta;

	Producto ProductoABuscar;
	
	Producto ProductoABuscarEditar;

	@PostConstruct
	public void init() {
		RepositorioProductos.save(new Producto("Camiseta Nike", 12, 20, 10));
		RepositorioProductos.save(new Producto("Sudadera ADIDAS",1231245, 50, 10));
		RepositorioProductos.save(new Producto("MAQUEDA", 132, 20, 10));
		RepositoryOferta.save(new Oferta(0.5));
	}

	// FALTA QUE SANMA HAGA EL HTML DE VER TODOS LOS PRODUCTOS
	@GetMapping("/listadoProductos")
	public String mostrarProductos(Model model) {
		model.addAttribute("productos", RepositorioProductos.findAll());
		return "modificarUsuario";
	}

	
	

	
	
	@GetMapping("/buscarCodigoEliminar")
	public String eliminarProducto(Model model) {
		return "buscarCodigoEliminar";
	}
	
	@PostMapping("/eliminarProductoImplementado")
	public String eliminarProductoImplementado(Model model, @RequestParam int codigo) {
		ProductoABuscar = RepositorioProductos.findByCodigo(codigo);
		if (ProductoABuscar==null) {
			return "/error";
		}
		RepositorioProductos.deleteById(ProductoABuscar.getId());
		return "/bienvenida";
	}

	
	
	
	
	
	
	
	
	@GetMapping("/agregarProductos")
	public String agregarProducto(Model model) {
		return "agregarProductos";
	}

	@PostMapping("/guardarProducto")
	public String guardarProducto(Model model, @RequestParam String nombre, @RequestParam int codigo,
			@RequestParam int precio, @RequestParam int unidades) {

		Producto producto = RepositorioProductos.findByCodigo(codigo);

		if (producto == null) {
			RepositorioProductos.save(new Producto(nombre, codigo, precio, unidades));
			return "bienvenida";
		}
		return "/bienvenida";
	}

	
	
	
	
	
	
	
	
	@GetMapping("/buscarCodigo")
	public String buscarCodigo(Model model) {
		return "buscarCodigo";
	}

	@PostMapping("/verProductoImplementado")
	public String verProductoImplementado(Model model, @RequestParam int codigo) {
		ProductoABuscar = RepositorioProductos.findByCodigo(codigo);
		if (ProductoABuscar==null) {
			return "/error";
		}
		return "/redireccion";
	}

	@GetMapping("/mostrarProducto")
	public String mostrarProducto(Model model) {
		
		String Nombre = ProductoABuscar.getNombre();
		int Codigo = ProductoABuscar.getCodigo();
		int precio =  ProductoABuscar.getPrecio();
		int Unidades = ProductoABuscar.getUnidades();		
		
		model.addAttribute("Nombre",Nombre);
		model.addAttribute("Codigo", Codigo);
		model.addAttribute("Precio",precio);
		model.addAttribute("Unidades", Unidades);
		return "verProducto";
	}
	
	
	
	
	@GetMapping("/buscarCodigoEditarProducto")
	public String buscarCodigoEditarProducto(Model model) {
		return "buscarCodigoEditarProducto";
	}
	
	
	
	@PostMapping("/modificarProductoImplementado")
	public String modificarProductoImplementado(Model model, @RequestParam int codigo) {
		ProductoABuscarEditar = RepositorioProductos.findByCodigo(codigo);
		if (ProductoABuscarEditar==null) {
			return "/error";
		}
		return "/redireccionEditarProducto";
	}
	
	@PostMapping("/modificarProductoImplementado2")
	public String modificarProductoImplementado2(Model model, @RequestParam String nombre,
			@RequestParam int precio, @RequestParam int unidades) {
		ProductoABuscarEditar.setNombre(nombre);
		ProductoABuscarEditar.setPrecio(precio);
		ProductoABuscarEditar.setUnidades(unidades);
		RepositorioProductos.save(ProductoABuscarEditar);
		return "/editarProducto";
	}
	

	
	
	
	
	
	
	
	
	
	
	// PRODUCTOS CON OFERTA
	// FALTA QUE SANMA HAGA LOS HTML PARA ENLAZARLOS
	@Autowired
	private ProductoOfertaRepository RepositorioProductosOferta;

	@GetMapping("/mostrarOferta")
	public String mostrarProductosOferta(Model model) {
		model.addAttribute("oferta", RepositorioProductosOferta.findAll());
		return "productos/ver_productosOferta";
	}

	@GetMapping("/crearOferta")
	public String crearOferta(Model model) {
		model.addAttribute("oferta", new Oferta());
		return "productos/agregar_producto";
	}

	@PostMapping("/eliminarOferta")
	public String eliminarOferta(@ModelAttribute Oferta oferta, RedirectAttributes redirectAttrs) {

		redirectAttrs.addFlashAttribute("mensaje", "Eliminado correctamente");

		RepositorioProductosOferta.deleteById(oferta.getId());
		return "redirect:/productos/mostrarOferta";
	}
	/*
	 * @PostMapping(value = "/agregarOferta") public String
	 * guardarOferta(@ModelAttribute Oferta oferta) {
	 * 
	 * if (RepositorioProductosOferta.findByDescuento(oferta.getDescuento()) !=
	 * null) { return "redirect:/productos/agregarOferta"; }
	 * RepositorioProductosOferta.save(oferta);
	 * 
	 * return "redirect:/productos/agregarOferta"; }
	 */

}

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

	Producto ProductoOferta;

	@PostConstruct
	public void init() {
		RepositorioProductos.save(new Producto("Camiseta Nike", 12, 20, 10));
		RepositorioProductos.save(new Producto("Sudadera ADIDAS", 1231245, 50, 10));
		RepositorioProductos.save(new Producto("MAQUEDA", 132, 20, 10));
		RepositorioProductos.save(new Producto("Camiseta Adidas", 1, 20, 10));
		RepositoryOferta.save(new Oferta(0.5));

		/*
		 * Producto producto_prueba = new Producto("Prueba", 2, 2, 10); Oferta
		 * oferta_prueba=new Oferta(0.5);
		 * 
		 * 
		 * RepositoryOferta.save(oferta_prueba);
		 * producto_prueba.setOferta(oferta_prueba);
		 * RepositorioProductos.save(producto_prueba);
		 */
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
		if (ProductoABuscar == null) {
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
		if (ProductoABuscar == null) {
			return "/error";
		}
		return "/redireccion";
	}

	@GetMapping("/mostrarProducto")
	public String mostrarProducto(Model model) {

		String Nombre = ProductoABuscar.getNombre();
		int Codigo = ProductoABuscar.getCodigo();
		int precio = ProductoABuscar.getPrecio();
		int Unidades = ProductoABuscar.getUnidades();

		model.addAttribute("Nombre", Nombre);
		model.addAttribute("Codigo", Codigo);
		model.addAttribute("Precio", precio);
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
		if (ProductoABuscarEditar == null) {
			return "/error";
		}
		return "/redireccionEditarProducto";
	}

	@PostMapping("/modificarProductoImplementado2")
	public String modificarProductoImplementado2(Model model, @RequestParam String nombre, @RequestParam int precio,
			@RequestParam int unidades) {
		ProductoABuscarEditar.setNombre(nombre);
		ProductoABuscarEditar.setPrecio(precio);
		ProductoABuscarEditar.setUnidades(unidades);
		RepositorioProductos.save(ProductoABuscarEditar);
		return "/editarProducto";
	}

	// Queremos añadir una oferta a un producto
	// Buscaremos el producto con su codigo y añadiremos la oferta, si ese codigo no
	// exite saldrá error.

	@GetMapping("/añadirOferta")
	public String añadirOferta(Model model) {
		return "añadirOferta";
	}

	@PostMapping("/Oferta")
	public String Oferta(Model model, @RequestParam int codigo, @RequestParam double descuento) {

		Producto producto = RepositorioProductos.findByCodigo(codigo);

		if (producto == null) {
			return "/error";
		} else {
			Oferta oferta_prueba = new Oferta(descuento);
			RepositoryOferta.save(oferta_prueba);
			producto.setOferta(oferta_prueba);

			int precio = producto.getPrecio();
			producto.setPrecioInicial(precio);

			producto.setOferta_Aplicada(descuento);
			descuento = 1 - descuento;
			int precioFinal = (int) (precio * descuento);

			producto.setPrecio(precioFinal);

			RepositorioProductos.save(producto);

		}
		return "/bienvenida";
	}

	@GetMapping("/eliminarOferta")
	public String eliminarOferta(Model model) {
		return "eliminarOferta";
	}

	@PostMapping("/OfertaEliminar")
	public String OfertaEliminar(Model model, @RequestParam int codigo) {

		Producto producto = RepositorioProductos.findByCodigo(codigo);

		Oferta oferta = producto.getOferta();

		if (producto == null) {
			return "/error";
		} else {

			int precioInicial = producto.getPrecioInicial();

			producto.setPrecio(precioInicial);

			producto.setOferta(null);

			RepositorioProductos.save(producto);

			RepositoryOferta.delete(oferta);

		}
		return "/bienvenida";
	}

}

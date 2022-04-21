package madclothes.controladores;

import javax.annotation.PostConstruct;

import madclothes.servicioInterno.servicioInternoEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import madclothes.entidades.CarritoCompra;
import madclothes.entidades.Oferta;
import madclothes.entidades.Producto;
import madclothes.entidades.WebUser;
import madclothes.repositorio.CarritoCompraRepository;
import madclothes.repositorio.ProductoOfertaRepository;
import madclothes.repositorio.ProductoRepository;
import madclothes.repositorio.WebUserRepository;
import madclothes.controladores.*;
import madclothes.servicioInterno.*;

@Controller
public class UsuarioController {

	@Autowired
	private WebUserRepository usuarioRepository;

	@Autowired
	private CarritoCompraRepository carritoRepository;
	@Autowired
	private ProductoRepository productoRepository;

	WebUser UsuarioABuscarEditar;
	WebUser UsuarioAEliminar;
	WebUser UsuarioAVer;

	@PostConstruct
	public void init() {
		usuarioRepository
				.save(new WebUser("Alejandro", "Panizo Jerez", "alejandro@gmail.com", "Calle Tulipan", 6436363));

		carritoRepository
				.save(new CarritoCompra(usuarioRepository.findByTelefono(1), productoRepository.findByCodigo(1)));

	}

	@GetMapping("/buscarCodigoUsuario")
	public String buscarCodigo(Model model) {
		return "buscarCodigoUsuario";
	}

	@PostMapping("/verUsuarioImplementado")
	public String verUsuarioImplementado(Model model, int telefono) {
		UsuarioAVer = usuarioRepository.findByTelefono(telefono);
		if (UsuarioAVer == null) {
			return "/error";
		}
		return "/redireccionUsuario";
	}

	@GetMapping("/mostrarUsuario")
	public String mostrarUsuario(Model model) {

		String nombre = UsuarioAVer.getNombre();
		String apellido = UsuarioAVer.getApellidos();
		String correo = UsuarioAVer.getCorreo();
		String calle = UsuarioAVer.getCorreo();
		int telefono1 = UsuarioAVer.getTelefono();

		model.addAttribute("Nombre", nombre);
		model.addAttribute("Apellidos", apellido);
		model.addAttribute("Correo", correo);
		model.addAttribute("Calle", calle);
		model.addAttribute("Telefono", telefono1);
		return "Usuario";
	}

	@GetMapping("/buscarCorreoEliminarUsuario")
	public String eliminarUsuario(Model model) {
		return "buscarCorreoEliminarUsuario";
	}

	@PostMapping("/borrarUsuario")
	public String borrarUsuario(Model model, @RequestParam int telefono) {
		WebUser eliminar = usuarioRepository.findByTelefono(telefono);

		if (eliminar == null) {
			return "/error";
		}
		usuarioRepository.deleteById(eliminar.getId());
		return "/bienvenida";
	}

	@GetMapping("Usuario")
	public String Usuario(Model model) {
		return "Usuario";
	}

	@GetMapping("/agregarUsuario")
	public String agregarUsuario(Model model) {
		return "agregarUsuario";
	}

	@Autowired
	private PasswordEncoder passwordEncoder;

	@PostMapping("/registrarUsuario")
	public String registrarUsuario(Model model, @RequestParam String nombre, @RequestParam String apellidos,
			@RequestParam String correo, @RequestParam String direccion, @RequestParam int telefono,
			@RequestParam String Contraseña) {
		WebUser aux = usuarioRepository.findByTelefono(telefono);
		if (aux == null) {
			usuarioRepository.save(new WebUser(nombre, apellidos, correo, direccion, telefono, passwordEncoder.encode(Contraseña), "USER"));
			WebUser UsuarioCorreo = usuarioRepository.findByTelefono(telefono);
			if(servicioInternoEmail.sendRegisterEmail(UsuarioCorreo)){
				return "bienvenida";
			}
			return "bienvenida";
		}
		return "bienvenida";
	}

	@GetMapping("/buscarCorreoEditarUsuario")
	public String buscarCorreoEditarUsuario(Model model) {
		return "buscarCorreoEditarUsuario";
	}

	@PostMapping("/modificarUsuario")
	public String modificarUsuario(Model model, @RequestParam int telefono) {
		UsuarioABuscarEditar = usuarioRepository.findByTelefono(telefono);
		if (UsuarioABuscarEditar != null) {
			return "/error";
		}
		return "/redireccionEditarUsuario";
	}

	@PostMapping("/modificarUsuario2")
	public String modificarUsuario2(Model model, @RequestParam String correo, @RequestParam String direccion,
			@RequestParam int telefono) {
		WebUser usuario = usuarioRepository.findByTelefono(telefono);
		if (usuario != null) {
			usuario.setTelefono(telefono);
			usuario.setDireccion(direccion);
			usuarioRepository.save(usuario);
		} else {
			model.addAttribute("Usuario", "Usuario no existente");
		}
		return "/editarUsuario";
	}

}
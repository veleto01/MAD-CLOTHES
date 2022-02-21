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
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	UsuarioRepository usuarioRepository;	
	
	@PostConstruct
	public void init(){
		usuarioRepository.save(new Usuario("Alejandro","Panizo Jerez","alejandro@gmail.com","Calle Tulipan","6436363"));
		usuarioRepository.save(new Usuario("Paco","Fernandez Martin","paco@gmail.com","Calle Margarita","6936352"));
	}
	@GetMapping("/usuario")
	public String mostrarUsuario(Model model,String correo) {
		Usuario usuario= usuarioRepository.findByCorreo(correo);
		model.addAttribute("Nombre",usuario.getNombre());
		model.addAttribute("Apellidos",usuario.getApellidos());
		model.addAttribute("Correo",usuario.getCorreo());
		model.addAttribute("Calle",usuario.getDireccion());
		model.addAttribute("Telefono",usuario.getTelefono());
		return"Usuario";
	}
	
	@GetMapping("/borrarUsuario")
	public String borrarUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttrs) {
		usuarioRepository.delete(usuario);
		redirectAttrs.addFlashAttribute("mensaje","Usuario eliminado correctamente");
		return"redirect:/bienvenida";
	}
	
	@PostMapping("/registrarUsuario")
	public String nuevoUsuario(Model model,String nombre,String apellidos, String correo, String direccion,String telefono) {
		Usuario usuario=new Usuario(nombre,apellidos,correo,direccion,telefono);

		usuarioRepository.save(usuario);
		model.addAttribute("Usuario",usuario.getNombre());
		return"nuevoUsuario";
	}
	@PostMapping("/usuario/modificar")
	public String modificarUsuario(Model model,String correo, String direccion,String telefono) {
		 usuarioRepository.findByCorreo(correo).setTelefono(telefono);
		 usuarioRepository.findByCorreo(correo).setDireccion(direccion);
		 return"Usuario";
	}
	
}

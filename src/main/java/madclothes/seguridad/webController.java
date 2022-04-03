package madclothes.seguridad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


//import es.codeurjc.security.User;
import madclothes.entidades.Usuario;
import madclothes.repositorio.UsuarioRepository;

@Controller
public class webController {
	
	@Autowired
	private UsuarioRepository RepositorioUsuario;
	
	@GetMapping("/")
	public String index() {
		return "bienvenida";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/loginerror")
	public String loginerror() {
		return "loginerror";
	}

	@GetMapping("/private")
	public String privatePage(Model model, HttpServletRequest request) {

		String nombre = request.getUserPrincipal().getName();
		
		Usuario user = RepositorioUsuario.findByNombre(nombre);

		model.addAttribute("username", user.getNombre());		
		model.addAttribute("admin", request.isUserInRole("ADMIN"));

		return "private";
	}

	@GetMapping("/administrador")
	public String admin() {
		return "administrador";
	}
	
}

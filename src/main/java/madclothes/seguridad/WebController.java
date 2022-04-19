package madclothes.seguridad;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import madclothes.repositorio.*;
import madclothes.entidades.*;
@Controller
public class WebController {


	@GetMapping("/")
	public String index(Model model,HttpServletRequest request) {
		model.addAttribute("admin", request.isUserInRole("ADMIN"));
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
	

}

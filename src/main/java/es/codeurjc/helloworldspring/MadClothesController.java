package es.codeurjc.helloworldspring;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MadClothesController {

	@Autowired
	private ProductosRepository repository;
	
	@PostConstruct
	public void init() {
		repository.save(new Productos("Camiseta Nike", 10, "Buen tejido"));
		repository.save(new Productos("Sudadera adidas", 20, "Extra grande"));
	}
	@GetMapping("/")
	public String bienvenida(Model model, Pageable page) {

		model.addAttribute("Productos", repository.findAll(page));

		return "bienvenida";
	}
	

}
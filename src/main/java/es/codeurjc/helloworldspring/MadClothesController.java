package es.codeurjc.helloworldspring;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MadClothesController {

	@Autowired
	private ProductosRepository Productos_Repository;
	
	
	@PostConstruct
	public void init() {
		Productos_Repository.save(new Productos("Camiseta Nike", 10, "Buen tejido",11111));
		Productos_Repository.save(new Productos("Sudadera adidas", 20, "Extra grande",11111));
		
		
		
	}
	@GetMapping("/")
	public String bienvenida(Model model, Pageable page) {

		model.addAttribute("Productos", Productos_Repository.findAll(page));

		return "bienvenida";
	}
	
	@GetMapping(value = "/CarritoCompra")
    public String CarritoCompra(Model model) {
        model.addAttribute("productos", Productos_Repository.findAll());
        return "bienvenida/CarritoCompra";
    }
	
	
	
	@Autowired
	private UsuarioRepository Usuario_Repository;
	
        @RequestMapping(value="/saveUser",method=RequestMethod.POST)
        public Boolean saveUser(@RequestBody Usuario u){
              return Usuario_Repository.saveUser(u);
        }
	
	
	
	
//Implementación ventanas	
	@GetMapping("/Categorías")
	public String Categorías(Model model, Pageable page) {

		model.addAttribute("1", Productos_Repository.findAll(page));

		return "Categorías";
	}
	/*
	@GetMapping("/CarritoCompra")
	public String CarritoCompra(Model model, Pageable page) {

		model.addAttribute("2", Productos_Repository.findAll(page));

		return "CarritoCompra";
	}
	
*/
	
	
}
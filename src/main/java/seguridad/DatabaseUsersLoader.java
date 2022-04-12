package seguridad;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;

import madclothes.repositorio.*;
import madclothes.entidades.*;


@Controller
public class DatabaseUsersLoader {
	@Autowired
	private UsuarioRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@PostConstruct
	private void initDatabase() {
		List<String> listaRolesAdmin=new ArrayList<String>();

		listaRolesAdmin.add(Usuario.ROL_ADMIN);
		Usuario admin = userRepository.findByNombre("admin123");
		if (admin==null) userRepository.save(new Usuario("admin123",passwordEncoder.encode("admin"),listaRolesAdmin,123));
		
	}
}
package madclothes.entidades;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import madclothes.repositorio.UsuarioRepository;

//import madclothes.repositorio.UserRepository;

@Component
public class BasedatosUsuarios {

    @Autowired
    private UsuarioRepository UsuarioRepository;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initDatabase() {
    	
    	UsuarioRepository.save(new Usuario("user", passwordEncoder.encode("pass"), "USER"));
    	UsuarioRepository.save(new Usuario("admin", passwordEncoder.encode("adminpass"), "USER", "ADMIN"));
    }
}


package madclothes.seguridad;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import madclothes.repositorio.*;
import madclothes.entidades.*;

@Component
public class DatabaseUsersLoader {

    @Autowired
    private UsuarioRepository userRepository;
    
    @Autowired
	private PasswordEncoder passwordEncoder;

    @PostConstruct
    private void initDatabase() {
    	
    	userRepository.save(new Usuario("user", passwordEncoder.encode("pass"), 123,"USER"));
		userRepository.save(new Usuario("admin", passwordEncoder.encode("admin"),12 ,"USER", "ADMIN"));
    }
}

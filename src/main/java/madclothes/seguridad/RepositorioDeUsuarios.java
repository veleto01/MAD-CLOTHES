package madclothes.seguridad;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import madclothes.entidades.Usuario;
import madclothes.repositorio.UsuarioRepository;

@Service
public class RepositorioDeUsuarios implements UserDetailsService {

	@Autowired
	private UsuarioRepository userRepository;

	@Override							//String username
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario user = userRepository.findByNombre(username);
				//user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
				if (user==null) {
					new UsernameNotFoundException("User not found");
		}
			

		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role));
		}

		return new org.springframework.security.core.userdetails.User(user.getNombre(), 
				user.getEncodedPassword(), roles);

	}
}

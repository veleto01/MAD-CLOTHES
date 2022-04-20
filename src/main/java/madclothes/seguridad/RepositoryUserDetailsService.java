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
import madclothes.repositorio.*;
import madclothes.entidades.*;

@Service
public class RepositoryUserDetailsService implements UserDetailsService {

	@Autowired
	private WebUserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		WebUser user = userRepository.findByNombre(username);
		if (user==null) {
            new UsernameNotFoundException("User not found");
		}
		List<GrantedAuthority> roles = new ArrayList<>();
		for (String role : user.getRoles()) {
			roles.add(new SimpleGrantedAuthority("ROLE_" + role));
		}

		return new org.springframework.security.core.userdetails.User(user.getNombre(), 
				user.getPasswordHash(), roles);

	}
}

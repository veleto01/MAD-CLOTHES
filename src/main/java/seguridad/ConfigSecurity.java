package seguridad;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;



@Configuration
public class ConfigSecurity extends WebSecurityConfigurerAdapter {

	@Autowired
	private RepositoryUserDetailsService repositorio;

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { return new
	 * BCryptPasswordEncoder(10, new SecureRandom()); }
	 * 
	 * @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 * Exception {
	 * 
	 * auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()
	 * ); }
	 * 
	 * 
	 * @Override protected void configure(HttpSecurity http) throws Exception {
	 * 
	 * // Public pages http.authorizeRequests().antMatchers("/").permitAll();
	 * http.authorizeRequests().antMatchers("/login").permitAll();
	 * http.authorizeRequests().antMatchers("/loginerror").permitAll();
	 * http.authorizeRequests().antMatchers("/logout").permitAll();
	 * http.authorizeRequests().antMatchers("/AtencionCliente").permitAll();
	 * http.authorizeRequests().antMatchers("/listaProductos").permitAll();
	 * 
	 * // Usuarios
	 * http.authorizeRequests().antMatchers("/CarritoCompra").hasAnyRole("USER"); //
	 * Admins
	 * http.authorizeRequests().antMatchers("/administrador").hasAnyRole("ADMIN");
	 * http.authorizeRequests().antMatchers("/gestionOferta").hasAnyRole("ADMIN");
	 * http.authorizeRequests().antMatchers("/gestionProductos").hasAnyRole("ADMIN")
	 * ;
	 * http.authorizeRequests().antMatchers("/gestionUsuario").hasAnyRole("ADMIN");
	 * 
	 * // Login form http.formLogin().loginPage("/login");
	 * http.formLogin().usernameParameter("username");
	 * http.formLogin().passwordParameter("password");
	 * http.formLogin().defaultSuccessUrl("/private");
	 * http.formLogin().failureUrl("/loginerror");
	 * 
	 * // Logout http.logout().logoutUrl("/logout");
	 * http.logout().logoutSuccessUrl("/");}
	 * 
	 * }
	 */

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder(10, new SecureRandom());
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.userDetailsService(repositorio).passwordEncoder(passwordEncoder());
	}
	
	@Override protected void configure(HttpSecurity http) throws Exception {
		 
		  // Public pages http.authorizeRequests().antMatchers("/").permitAll();
		  http.authorizeRequests().antMatchers("/login/login").permitAll();
		  http.authorizeRequests().antMatchers("/login/loginerror").permitAll();
		  http.authorizeRequests().antMatchers("/login/logout").permitAll();
		  http.authorizeRequests().antMatchers("/AtencionCliente").permitAll();
		  http.authorizeRequests().antMatchers("/listaProductos").permitAll();
		  
		  // Usuarios
		  http.authorizeRequests().antMatchers("/CarritoCompra").hasAnyRole("USER"); //
		  http.authorizeRequests().antMatchers("/administrador").hasAnyRole("ADMIN");
		  http.authorizeRequests().antMatchers("/gestionOferta").hasAnyRole("ADMIN");
		  http.authorizeRequests().antMatchers("/gestionProductos").hasAnyRole("ADMIN");
		  http.authorizeRequests().antMatchers("/gestionUsuario").hasAnyRole("ADMIN");
		  
		  // Login form http.formLogin().loginPage("/login");
		  http.formLogin().usernameParameter("username");
		  http.formLogin().passwordParameter("password");
		  http.formLogin().defaultSuccessUrl("/private");
		  http.formLogin().failureUrl("/login/loginerror");
		  
		  // Logout http.logout().logoutUrl("/logout");
		  http.logout().logoutSuccessUrl("/");}
		  
		  }

package es.codeurjc.helloworldspring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	public Usuario existsByCorreo(String correo);
	public Usuario findByCorreo(String correo);
    public Usuario findByNameAndCorreo(String name,String correo);

}
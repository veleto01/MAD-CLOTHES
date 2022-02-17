package es.codeurjc.helloworldspring;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	public List<Usuario> findByEmail(String email);
    public List<Usuario> findByNameAndEmail(String name,String email);
}
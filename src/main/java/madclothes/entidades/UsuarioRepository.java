package madclothes.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import madclothes.entidades.Producto;
import madclothes.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
	
	Usuario findByTelefono(int telefono);
	
	List<Usuario> findByCorreoIgnoreCase(String correo);
    }
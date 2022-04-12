package madclothes.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import madclothes.entidades.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByTelefono(int telefono);

	Usuario findByNombre(String nombre);

	List<Usuario> findByCorreoIgnoreCase(String correo);
}
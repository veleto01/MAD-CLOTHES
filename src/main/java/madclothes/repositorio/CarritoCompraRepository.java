package madclothes.repositorio;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import madclothes.entidades.CarritoCompra;
import madclothes.entidades.Usuario;

public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Long> {
	//Optional<CarritoCompra> findByUser(Optional<Usuario> usuario);
	
}


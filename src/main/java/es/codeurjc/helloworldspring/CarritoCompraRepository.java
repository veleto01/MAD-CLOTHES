package es.codeurjc.helloworldspring;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Long> {
	Optional<CarritoCompra> findByUser(Optional<Usuario> usuario);
	
}

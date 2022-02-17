package es.codeurjc.helloworldspring;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductosRepository extends JpaRepository<Productos, Long> {
	//Productos findFirstByCodigo(String codigo);
}
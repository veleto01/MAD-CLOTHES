package madclothes.repositorio;







import org.springframework.data.jpa.repository.JpaRepository;

import madclothes.entidades.CarritoCompra;
import madclothes.entidades.Producto;


public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Integer> {

	
	//CarritoCompra findByProducto(int codigo);
	CarritoCompra findByUsuario(int telefono);
	//CarritoCompra findById(int id);
	
}


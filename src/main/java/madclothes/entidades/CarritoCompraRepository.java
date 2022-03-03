package madclothes.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import madclothes.entidades.CarritoCompra;
import madclothes.entidades.Producto;

@Service
public interface CarritoCompraRepository extends JpaRepository<CarritoCompra, Integer> {

	
	//CarritoCompra findByProducto(int codigo);
	
	//CarritoCompra findById(int id);

	CarritoCompra findByUsuarioTelefono(int telefono);
	
	
}
package madclothes.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import madclothes.entidades.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	Producto findByCodigo(int codigo);
}



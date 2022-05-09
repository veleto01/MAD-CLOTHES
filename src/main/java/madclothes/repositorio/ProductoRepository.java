package madclothes.repositorio;

import java.util.Optional;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import madclothes.entidades.Producto;



public interface ProductoRepository extends JpaRepository<Producto, Integer> {
	
	@CacheEvict(allEntries=true)
	Producto save(Producto producto);
	
	@CacheEvict
	void delete(Producto producto);
	
	
	@Cacheable
	Producto findByCodigo(int codigo);
}



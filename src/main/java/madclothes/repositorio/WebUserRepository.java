package madclothes.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import madclothes.entidades.Producto;
import madclothes.entidades.WebUser;

@Repository
public interface WebUserRepository extends CrudRepository<WebUser, Integer> {
	
	WebUser findByTelefono(int telefono);
	
	List<WebUser> findByCorreoIgnoreCase(String correo);
	@Cacheable
	WebUser findByNombre(String nombre);
	
	
	@CacheEvict(allEntries=true)
	WebUser save(WebUser WebUser);
	
	@CacheEvict
	void delete(WebUser WebUser);

	
	
    }
package madclothes.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import madclothes.entidades.Oferta;
import madclothes.entidades.Producto;


public interface ProductoOfertaRepository extends JpaRepository<Oferta, Integer> {

}

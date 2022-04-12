package madclothes.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import madclothes.entidades.Oferta;


public interface ProductoOfertaRepository extends JpaRepository<Oferta, Integer> {

}

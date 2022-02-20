package es.codeurjc.helloworldspring;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductoOfertaRepository extends JpaRepository<Oferta, Integer> {
	//List<Oferta> findByDescuento(double Descuento);
	
}

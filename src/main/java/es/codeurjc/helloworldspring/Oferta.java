package es.codeurjc.helloworldspring;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;




@Entity
public class Oferta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	
	
	@OneToMany
	 private List<Productos> Producto_Descuento;
	
	private double Descuento;
	
	
	public Oferta(){}
	
	public Oferta(double Descuento_Producto){
		super();
		this.Descuento=Descuento_Producto;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public double getDescuento() {
		return Descuento;
	}
	
	public void setDescuento(double descuento) {
		Descuento = descuento;
	}
	
	
	
}

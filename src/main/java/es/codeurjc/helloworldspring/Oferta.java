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
	private int id;
	
	
	
	@OneToMany
	 private List<Producto> Producto_Descuento;
	
	private double Descuento;
	
	
	public Oferta(){}
	
	public Oferta(double Descuento_Producto){
		this.Descuento=Descuento_Producto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public double getDescuento() {
		return Descuento;
	}
	
	public void setDescuento(float descuento) {
		Descuento = descuento;
	}
	
	
	
}
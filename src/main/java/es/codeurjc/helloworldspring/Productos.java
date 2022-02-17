/*package es.codeurjc.helloworldspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotNull(message = "El producto debe contener nombre")
	@Size(min = 1, max = 50, message = "El nombre debe medir entre 1 y 50")
	private String Nombre;
	
	@NotNull(message = "Debes especificar el precio")
    @Min(value = 0, message = "El precio mínimo es 0")
	private int Precio;
	
	@NotNull(message = "Especifica el código del producto")
    @Size(min = 5, max = 5, message = "El código debe tener 5 digitos")
    private int codigo;
	
	private String valoracion;

	public Productos() {}

	public Productos(String Nombre, int precio, String valoracion, int codigo ) {
		this.Nombre = Nombre;
		this.Precio = precio;
		this.valoracion = valoracion;
		this.codigo = codigo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProducto() {
		return Nombre;
	}

	public void setProducto(String producto) {
		Nombre = producto;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public String toString() {
		return "Producto [Producto=" + Nombre + ", Precio=" + Precio + ", valoracion=" + valoracion + "]";
	}
	
	
}
*/
package es.codeurjc.helloworldspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Productos {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String Producto;
	private int Precio;
	private String valoracion;
	private int codigo;
	
	@OneToOne
	private Oferta oferta;
	

	public Productos() {}

	
	public Productos(String Nombre, int precio, String valoracion, int codigo ) {
		this.Producto = Nombre;
		this.Precio = precio;
		this.valoracion = valoracion;
		this.codigo = codigo;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProducto() {
		return Producto;
	}

	public void setProducto(String producto) {
		Producto = producto;
	}

	public int getPrecio() {
		return Precio;
	}

	public void setPrecio(int precio) {
		Precio = precio;
	}

	public String getValoracion() {
		return valoracion;
	}

	public void setValoracion(String valoracion) {
		this.valoracion = valoracion;
	}
	
	@Override
	public String toString() {
		return "Producto [Producto=" + Producto + ", Precio=" + Precio + ", valoracion=" + valoracion + "]";
	}
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	
	
}
package es.codeurjc.helloworldspring;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;

@Entity
public class Usuario {
	
	
	@Id
	@Email
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String correo;
	
	private String nombre;
	private String apellidos;
	private String telefono;
	private String direccion;
	
	public Usuario() {
		
	}
	public Usuario(String n, String a,String c, String d, String t){
		this.nombre=n;
		this.apellidos=a;
		this.correo=c;
		this.direccion=d;
		this.telefono=t;
	}

		
	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	@Override
	public String toString() {
		return "Usuario [correo=" + correo + ", nombre=" + nombre + ", apellidos=" + apellidos + ", telefono="
				+ telefono + ", direccion=" + direccion + "]";
	}
	
	
	
}

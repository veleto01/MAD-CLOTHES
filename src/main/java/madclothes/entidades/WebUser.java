package madclothes.entidades;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WebUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String correo;
	private String nombre;
	private String apellidos;
	private int telefono;
	private String direccion;

	private String passwordHash;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private List<String> roles;

	public WebUser(String n, String a, String c, String d, int t) {
		this.nombre = n;
		this.apellidos = a;
		this.correo = c;
		this.direccion = d;
		this.telefono = t;
	}
	public WebUser(String n, String a, String c, String d, int t,int id) {
		this.nombre = n;
		this.apellidos = a;
		this.correo = c;
		this.direccion = d;
		this.telefono = t;
		this.id=id;
	}
	public WebUser(String name, String passwordHash,int t,String... roles) {
        this.nombre = name;
        this.passwordHash = passwordHash;
        this.telefono = t;
        this.roles = List.of(roles);

    }

	public WebUser(String n, String a, String c, String d, int t,String passwordHash,String... roles) {
		this.nombre = n;
		this.apellidos = a;
		this.correo = c;
		this.direccion = d;
		this.telefono = t;
		this.passwordHash = passwordHash;
		this.roles = List.of(roles);
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public WebUser() {

	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono2) {
		this.telefono = telefono2;
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
	public String getPasswordHash() {
		return passwordHash;
	}
	public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}


}
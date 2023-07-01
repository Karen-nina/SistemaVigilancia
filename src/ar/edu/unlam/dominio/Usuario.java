package ar.edu.unlam.dominio;

public class Usuario {

	String mail;
	String nombre;
	Integer edad;
	
	public Usuario(String mail, String nombre, Integer edad) {
		super();
		this.mail = mail;
		this.nombre = nombre;
		this.edad = edad;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Integer getEdad() {
		return edad;
	}

	public void setEdad(Integer edad) {
		this.edad = edad;
	}

	
}

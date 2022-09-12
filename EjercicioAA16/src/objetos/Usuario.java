package objetos;

public class Usuario extends Persona {

	private String nombreUsuario;
	private String contrasena;
	
	public Usuario(String nombre, String nombreUsuario, String contrasena) {
		super(nombre);
		this.nombreUsuario = nombreUsuario;
		this.contrasena = contrasena;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
}

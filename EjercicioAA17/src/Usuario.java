
public class Usuario {
	
	private String nombre;
	
	public Usuario(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public boolean adivinaElNumero(int n, AdivinaNumero a) {
		return a.adivinaElNumero(n);
	}
}

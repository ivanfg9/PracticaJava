package objetos;

public class Artista extends Persona {

	private String nombreArtistico;
	
	public Artista(String nombre, String nombreArtistico) {
		super(nombre);
		this.nombreArtistico = nombreArtistico;
	}

	public String getNombreArtistico() {
		return nombreArtistico;
	}

	public void setNombreArtistico(String nombreArtistico) {
		this.nombreArtistico = nombreArtistico;
	}
}

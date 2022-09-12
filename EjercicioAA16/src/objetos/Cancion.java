package objetos;

public class Cancion implements Recaudacion {

	private static final int BENEFICIO = 2;
	
	private String titulo;
	private int reproducciones;
	
	public Cancion(String titulo, int reproducciones) {
		this.titulo = titulo;
		this.reproducciones = reproducciones;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getReproducciones() {
		return reproducciones;
	}

	public void setReproducciones(int reproducciones) {
		this.reproducciones = reproducciones;
	}

	@Override
	public int calculoRecaudacion() {
		return reproducciones*BENEFICIO;
	}

	@Override
	public String toString() {
		return "Cancion [titulo=" + titulo + ", reproducciones=" + reproducciones + "]";
	}
}

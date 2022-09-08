
public class Pelicula {
	private String titulo;
	private double recaudacion;
	
	public Pelicula(String titulo, double recaudacion) {
		this.titulo = titulo;
		this.recaudacion = recaudacion;
	}
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public double getRecaudacion() {
		return recaudacion;
	}

	public void setRecaudacion(double recaudacion) {
		this.recaudacion = recaudacion;
	}
	
	@Override
	public String toString() {
		return "Pelicula [titulo=" + titulo + ", recaudacion=" + recaudacion + "]";
	}
}

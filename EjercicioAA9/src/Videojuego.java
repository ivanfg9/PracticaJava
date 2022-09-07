
public class Videojuego implements PrecioPorTitulo {

	private String titulo;
	private int stock;
	private double precio;
	private String genero;
	private String consola;
	
	public Videojuego(String titulo, int stock, double precio, String genero, String consola) {
		this.titulo = titulo;
		this.stock = stock;
		this.precio = precio;
		this.genero = genero;
		this.consola = consola;
	}

	@Override
	public double beneficios() {
		return stock*precio;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getConsola() {
		return consola;
	}

	public void setConsola(String consola) {
		this.consola = consola;
	}
}

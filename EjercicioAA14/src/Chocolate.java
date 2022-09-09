
public class Chocolate extends Golosina implements Produccion {
	private static final int TEMP_MAX = 40;
	
	private int cantidad;
	
	public Chocolate(String nombre, int cantidad) {
		super(nombre);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public boolean produccionChocolate(int temperaturaMaxima) {
		return temperaturaMaxima<=TEMP_MAX;
	}
}

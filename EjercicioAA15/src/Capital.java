
public class Capital extends Provincia {
	
	private String capital;

	public Capital(String provincia, String capital) {
		super(provincia);
		this.capital = capital;
	}

	public String getCapital() {
		return capital;
	}

	public void setCapital(String capital) {
		this.capital = capital;
	}

	@Override
	public String toString() {
		return "Capital [provincia = " + this.getNombre() + ",capital=" + capital + "]";
	}
}

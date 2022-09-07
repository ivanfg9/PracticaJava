import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		try {
			String nombreArchivo = "beneficiosTitulo.txt";
			Path ruta = Paths.get(nombreArchivo);
			List<String> lineas = new ArrayList<>();
			List<Videojuego> videojuegos = new ArrayList<>();
			videojuegos.add(new Videojuego("DARK SOULS 3", 10000, 5, "Aventura", "PC"));
			videojuegos.add(new Videojuego("THE LAST OF US", 50000, 10, "Terror", "PS5"));
			videojuegos.add(new Videojuego("FIFA 2022", 60000, 15, "Deportes", "XBOX One"));
			videojuegos.add(new Videojuego("MARIO BROSS", 45000, 1, "Arcade", "Nintendo Switch"));
			videojuegos.add(new Videojuego("DOOM 2", 100000, 1, "Acción", "PC"));
			videojuegos.add(new Videojuego("FORZA HORIZON", 50000, 5, "Conducción", "PS5"));
			
			for(Videojuego v:videojuegos) {
				lineas.add("Titulo: " + v.getTitulo() +
						" | Unidades vendidas: " + v.getStock() +
						" | Beneficios: " + v.beneficios());
				lineas.add("---------------------------------");
			}
			
			Files.write(ruta, lineas, StandardCharsets.UTF_8);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

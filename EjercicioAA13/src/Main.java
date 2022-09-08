import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		List<Pelicula> peliculas = new ArrayList<>();
		List<Pelicula> nuevasPeliculas = new ArrayList<>();
		nuevasPeliculas.add(new Pelicula("Avatar", 2098397339));
		nuevasPeliculas.add(new Pelicula("Avengers: Endgame", 2097501328));
		nuevasPeliculas.add(new Pelicula("Titanic", 2070647264));
		nuevasPeliculas.add(new Pelicula("Star Wars: Episode VII - The Force Awakens", 2069521700));
		nuevasPeliculas.add(new Pelicula("Avengers: Infinity War", 2048359754));
		nuevasPeliculas.add(new Pelicula("Spider-Man: No Way Home", 1910675428));
		nuevasPeliculas.add(new Pelicula("Jurassic World", 1671537444));
		nuevasPeliculas.add(new Pelicula("The Lion King", 1663250487));
		nuevasPeliculas.add(new Pelicula("The Avengers", 1518815515));
		nuevasPeliculas.add(new Pelicula("Furious 7", 1515341399));
		
		try {
			File archivoEntrada = new File("C:\\Users\\Ivan Fernandez\\git\\PracticaJava\\EjercicioAA13\\Peliculas_11_20.txt");
			Scanner scan = new Scanner(archivoEntrada);
			
			while(scan.hasNext()) {
				String linea = scan.nextLine();
				if(!linea.contains("Nombre")) {
					int posDolar = linea.indexOf("$");
					String titulo = linea.substring(0, posDolar);
					double recaudacion = Double.parseDouble(linea.substring(posDolar+1));
					peliculas.add(new Pelicula(titulo, recaudacion));
				}
			}
			
			int j;
			for(Pelicula p:nuevasPeliculas) {
				j=0;
				while(j<peliculas.size() && p.getRecaudacion()<peliculas.get(j).getRecaudacion()) {
					j++;
				}
				
				if(j<peliculas.size()) {
					peliculas.add(j, p);
				}
			}
			
			String nombreSalida = "top20_mejores_peliculas.txt";
			Path rutaSalida = Paths.get(nombreSalida);
			List<String> salida = new ArrayList<>();
			
			salida.add("Top 20 películas con más recaudación de la historia.");
			int i=1;
			for(Pelicula p:peliculas) {
				salida.add(i + ") Titulo: " + p.getTitulo() + " | Recaudación: " + p.getRecaudacion());
				i++;
			}
			Files.write(rutaSalida, salida, StandardCharsets.UTF_8);
			
			String nombreArchivo = "jenkinsFile";
			Path ruta = Paths.get(nombreArchivo);
			List<String> jenkinsFile = new ArrayList<>();
			
			jenkinsFile.add("pipeline{");
			jenkinsFile.add("	stages{");
			jenkinsFile.add("		stage(\"Build\"){");
			jenkinsFile.add("			steps{");
			jenkinsFile.add("				script{");
			jenkinsFile.add("					def dia = new Date()");
			jenkinsFile.add("					def fecha = dia.format(\"dd-MM-yyyy\")");
			jenkinsFile.add("					println \"Hola Mundo! EL día de hoy es ${fecha}. Este curso me hizo aprender muchísimo sobre Java\"");
			jenkinsFile.add("				}");
			jenkinsFile.add("			}");
			jenkinsFile.add("		}");
			jenkinsFile.add("	}");
			jenkinsFile.add("}");
			
			scan.close();
			Files.write(ruta, jenkinsFile, StandardCharsets.UTF_8);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

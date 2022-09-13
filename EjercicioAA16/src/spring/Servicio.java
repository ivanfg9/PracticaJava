package spring;

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

import org.springframework.stereotype.Service;

import objetos.Artista;
import objetos.Cancion;

@Service
public class Servicio {
	
private List<String> archivo;
	
	public Servicio() {
		archivo = new ArrayList<>();
	}
	
	public void generaArchivo() throws IOException {
		String nombreArchivo = "archivoSalida.txt";
		Path ruta = Paths.get(nombreArchivo);
		List<String> archivoSalida = new ArrayList<>();
		List<Cancion> canciones = new ArrayList<>();
		List<Artista> artistas = new ArrayList<>();
		
		for(String s:archivo) {
			if(s.contains("|")) {
				canciones.add(new Cancion(s.substring(0,s.indexOf("|")), Integer.valueOf(s.substring(s.indexOf("|")+1))));
			}
			else {
				artistas.add(new Artista(s,s));
			}
		}
		
		for(Cancion c:canciones) {
			archivoSalida.add("Título: " + c.getTitulo() + " | Recaudación: " + c.calculoRecaudacion());
		}
		
		for(Artista a:artistas) {
			archivoSalida.add("Nombre: " + a.getNombre() + " | Nombre artístico: " + a.getNombreArtistico());
		}
		
		Files.write(ruta, archivoSalida, StandardCharsets.UTF_8);
	}
	
	public void cargaTxts() throws FileNotFoundException {
		generaArchivoCanciones("C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\Ejercicio26\\Canciones 2020.txt");
		generaArchivoCanciones("C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\Ejercicio26\\Canciones 2021.txt");
		generaArchivoArtistas("C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\Ejercicio26\\Artistas 2020.txt");
		generaArchivoArtistas("C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\Ejercicio26\\Artistas 2021.txt");
	}
	
	private void generaArchivoCanciones(String ruta) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(ruta),"UTF-8");
		
		while(scan.hasNext()) {
			String linea = scan.nextLine();
			int i = 0;
			while(i<linea.length() && !Character.isDigit(linea.charAt(i))) {
				i++;
			}
			
			if(i<linea.length()) {
				String titulo = linea.substring(1, linea.lastIndexOf("'"));
				int reproducciones = Integer.valueOf(linea.substring(i));
				archivo.add(titulo + "|" + reproducciones);
			}
		}
	}
	
	private void generaArchivoArtistas(String ruta) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(ruta),"UTF-8");
		
		while(scan.hasNext()) {
			String linea = scan.nextLine();
			archivo.add(linea);
		}
	}
}

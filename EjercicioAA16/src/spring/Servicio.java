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
	
	public void generaArchivo(List<String> archivo) throws IOException {
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
			archivoSalida.add("T�tulo: " + c.getTitulo() + " | Recaudaci�n: " + c.calculoRecaudacion());
		}
		
		for(Artista a:artistas) {
			archivoSalida.add("Nombre: " + a.getNombre() + " | Nombre art�stico: " + a.getNombreArtistico());
		}
		
		Files.write(ruta, archivoSalida, StandardCharsets.UTF_8);
	}
	
	public List<String> cargaTxts() throws FileNotFoundException {
		List<String> archivoCombinado = new ArrayList<>();
		
		archivoCombinado = generaArchivoCanciones(archivoCombinado, "C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\EjercicioAA16\\Canciones 2020.txt");
		archivoCombinado = generaArchivoCanciones(archivoCombinado, "C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\EjercicioAA16\\Canciones 2021.txt");
		archivoCombinado = generaArchivoArtistas(archivoCombinado, "C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\EjercicioAA16\\Artistas 2020.txt");
		archivoCombinado = generaArchivoArtistas(archivoCombinado, "C:\\Users\\Ivan Fernandez\\Documentos\\Carpeta Trabajo Inicial\\EjercicioAA16\\Artistas 2021.txt");

		return archivoCombinado;
	}
	
	private List<String> generaArchivoCanciones(List<String> archivoIni, String ruta) throws FileNotFoundException{
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
				archivoIni.add(titulo + "|" + reproducciones);
			}
		}
		
		return archivoIni;
	}
	
	private List<String> generaArchivoArtistas(List<String> archivoIni, String ruta) throws FileNotFoundException{
		Scanner scan = new Scanner(new File(ruta),"UTF-8");
		
		while(scan.hasNext()) {
			String linea = scan.nextLine();
			archivoIni.add(linea);
		}
		
		return archivoIni;
	}
}
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ArchivoSalida implements GenerarArchivo {

	private String nombreUsuario;
	private String fechaLogin;
	private List<Capital> infoCapital;
	
	public ArchivoSalida(String nombreUsuario, List<Capital> capital) {
		this.nombreUsuario = nombreUsuario;
		this.fechaLogin = LocalDate.now().toString();
		infoCapital = new ArrayList<>(capital);
	}
	
	@Override
	public void generarTXTSalida(String nombreArchivoSalida) throws IOException {
		String nombreArchivo = nombreArchivoSalida;
		Path ruta = Paths.get(nombreArchivo);
		List<String> archivo = new ArrayList<>();
		
		if(nombreArchivo.equalsIgnoreCase("jenkinsFile")) {
			archivo = new ArrayList<>(generarJenkinsFile());
		}
		else {
			archivo = new ArrayList<>(generarSalida());
		}
		
		Files.write(ruta, archivo, StandardCharsets.UTF_8);
	}
	
	private List<String> generarJenkinsFile() {
		List<String> archivo = new ArrayList<>();
		
		archivo.add("pipeline{");
		archivo.add("	agent any");
		archivo.add("	stages{");
		archivo.add("		stage(\"Mostrar provincia\"){");
		archivo.add("			steps{");
		archivo.add("				script{");
		for(Capital c:infoCapital) {
			archivo.add("					println \"Provincia: " + c.getNombre() + " | Capital: " + c.getCapital() + "\"");
		}
		archivo.add("				}");
		archivo.add("			}");
		archivo.add("		}");
		archivo.add("	}");
		archivo.add("}");
		
		return archivo;
	}
	
	private List<String> generarSalida(){
		List<String> archivo = new ArrayList<>();
		archivo.add("Nombre del usuario: " + nombreUsuario);
		archivo.add("Fecha de login: " + fechaLogin);
		for(Capital c:infoCapital) {
			archivo.add("Provincia: " + c.getNombre() + " | Capital: " + c.getCapital());
		}
		
		return archivo;
	}

}

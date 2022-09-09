import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://www.el-tiempo.net/api/json/v1/provincias/41/municipios/41001/weather");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			int responseCode = con.getResponseCode();
			
			if(responseCode != 200) {
				throw new RuntimeException("HttpResponse (" + responseCode + ")");
			}
			
			Scanner scan = new Scanner(url.openStream());
			StringBuilder apiInfo = new StringBuilder();
			
			while(scan.hasNext()) {
				String linea = scan.nextLine();
				apiInfo.append(linea);
			}
			
			JSONObject json = new JSONObject(apiInfo.toString());
			JSONObject prediccion = json.getJSONObject("prediccion");
			JSONArray dia = prediccion.getJSONArray("dia");
			JSONObject temperatura = dia.getJSONObject(0).getJSONObject("temperatura");
			int temperaturaMax = Integer.valueOf(temperatura.getString("maxima"));
			String nombreArchivo = "salida_" + LocalDate.now() + ".txt";
			Path ruta = Paths.get(nombreArchivo);
			String jenkins = "jenkinsfile";
			Path rutaJenkins = Paths.get(jenkins);
			List<Chocolate> chocolates = new ArrayList<>();
			List<String> archivoSalida = new ArrayList<>();
			List<String> jenkinsFile = new ArrayList<>();
			
			
			chocolates.add(new Chocolate("Chocolate Blanco", 1000));
			chocolates.add(new Chocolate("Choclate Negro", 1500));
			chocolates.add(new Chocolate("Chocolate con almendras", 1200));
			chocolates.add(new Chocolate("Chocolate con castañas de caju", 1300));
			chocolates.add(new Chocolate("Chocolate en rama", 100));
			chocolates.add(new Chocolate("Chocolate con 70% de cacao", 1500));
			
			jenkinsFile.add("pipeline{");
			jenkinsFile.add("	agent any");
			jenkinsFile.add("	stages{");
			jenkinsFile.add("		stage(\"Cantidad producida chocolate\"){");
			jenkinsFile.add("			steps{");
			jenkinsFile.add("				script{");
			
			String muestraJenkins = "					println \"Nombre	CANTIDAD PRODUCIDA\r\n";
			int cantidadProducida = 0;
			for(Chocolate c:chocolates) {
				if(c.produccionChocolate(temperaturaMax)) {
					archivoSalida.add("Sí se ha podido producir " + c.getNombre() + " porque la temperatura es inferior a 40º (" 
									+ temperaturaMax + ") | Cantidad producida: " + c.getCantidad());
					System.out.println("Sí se ha podido producir " + c.getNombre() + " porque la temperatura es inferior a 40º (" 
									+ temperaturaMax + ") | Cantidad producida: " + c.getCantidad());
					cantidadProducida+=c.getCantidad();
					muestraJenkins += "					- " + c.getNombre() + "	" + c.getCantidad() + "\r\n";
				}
			}
			
			jenkinsFile.add(muestraJenkins + "					\"");
			jenkinsFile.add("				}");
			jenkinsFile.add("			}");
			jenkinsFile.add("		}");
			jenkinsFile.add("	}");
			jenkinsFile.add("}");
			
			if(cantidadProducida == 0) {
				archivoSalida.add("Cantidad producida final: " + cantidadProducida + 
								" debido a que la temperatura actual es mayor que 40º (" + temperaturaMax
								+ ")");
				System.out.println("Cantidad producida final: " + cantidadProducida + 
						" debido a que la temperatura actual es mayor que 40º (" + temperaturaMax
						+ ")");
			}
			else {
				archivoSalida.add("Cantidad producida final: " + cantidadProducida);
				System.out.println("Cantidad producida final: " + cantidadProducida);
			}
			
			Files.write(ruta, archivoSalida, StandardCharsets.UTF_8);
			Files.write(rutaJenkins, jenkinsFile, StandardCharsets.UTF_8);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (RuntimeException e) {
			e.printStackTrace();
		}
	}
}

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		try {
			URL url = new URL("https://public.opendatasoft.com/api/records/1.0/search/?dataset=provincias-espanolas&q=&rows=0&sort=-provincia&facet=ccaa&facet=provincia");
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			int responseCode = con.getResponseCode();
			
			if(responseCode != 200) {
				throw new RuntimeException("HttpResponseCode (" + responseCode + ")");
			}
			
			Scanner scan = new Scanner(url.openStream());
			StringBuilder apiInfo = new StringBuilder();
			
			while(scan.hasNext()) {
				String linea = scan.nextLine();
				apiInfo.append(linea);
			}
			
			JSONObject json = new JSONObject(apiInfo.toString());
			JSONArray facets = new JSONArray(json.getJSONArray("facet_groups"));
			JSONObject infoProvincias = new JSONObject();
			infoProvincias = facets.getJSONObject(1);
			JSONArray provincias = infoProvincias.getJSONArray("facets");
			List<Capital> infoCapitales = new ArrayList<>();
			
			System.out.println("Se están generando su fichero de salida y su JenkinsFile...");
			
			for(int i=0;i<provincias.length();i++) {
				infoCapitales.add(new Capital(provincias.getJSONObject(i).getString("path"),provincias.getJSONObject(i).getString("name")));
			}
			
			ArchivoSalida salida = new ArchivoSalida("Iván Fdez", infoCapitales);
			salida.generarTXTSalida("jenkinsFile");
			salida.generarTXTSalida("archivoSalida.txt");
			
			System.out.println("Archivos generados");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

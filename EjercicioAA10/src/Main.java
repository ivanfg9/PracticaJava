import java.net.HttpURLConnection;
import java.net.URL;
import java.time.LocalDate;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		try {
			URL url = new URL("https://www.el-tiempo.net/api/json/v1/provincias/28/municipios/28001/weather");
			
			System.out.print("Por favor, introduzca su nombre: ");
			String nombre = scan.nextLine();
			System.out.print("Bienvenid@ a la consulta del tiempo, " + nombre + ". ");
			
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.connect();
			int responseCode = con.getResponseCode();
			
			if(responseCode != 200) {
				throw new Exception("HttpResponse (" + responseCode + ")");
			}
			
			Scanner scanUrl = new Scanner(url.openStream());
			StringBuilder apiInfo = new StringBuilder();
			
			while(scanUrl.hasNext()) {
				String linea = scanUrl.nextLine();
				apiInfo.append(linea);
			}
			
			JSONObject json = new JSONObject(apiInfo.toString());
			JSONArray jsonArray = new JSONArray();
			json = json.getJSONObject("prediccion");
			jsonArray = json.getJSONArray("dia");
			
			
			JSONObject tiempoHoy = jsonArray.getJSONObject(0);
			System.out.println("El tiempo para el día " + LocalDate.now() + " es:");
			System.out.println();
			System.out.println("Racha máxima: " + tiempoHoy.getJSONArray("racha_max"));
			System.out.println("--------------------");
			System.out.println("Probabilidad de precipitación: " + tiempoHoy.getJSONArray("prob_precipitacion"));
			System.out.println("--------------------");
			System.out.println("Rachas de viento: " + tiempoHoy.getJSONArray("viento"));
			System.out.println("--------------------");
			System.out.println("UV máximo: " + tiempoHoy.get("uv_max"));
			System.out.println("--------------------");
			System.out.println("Cota de nieve: " + tiempoHoy.getJSONArray("cota_nieve_prov"));
			System.out.println("--------------------");
			System.out.println("Estado del cielo: " + tiempoHoy.getJSONArray("estado_cielo"));
			System.out.println("--------------------");
			System.out.println("Sensación térmica: " + tiempoHoy.getJSONObject("sens_termica"));
			System.out.println("--------------------");
			System.out.println("Humedad relativa: " + tiempoHoy.getJSONObject("humedad_relativa"));
			System.out.println("--------------------");
			System.out.println("Temperaturas: " + tiempoHoy.getJSONObject("temperatura"));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			scan.close();
		}
	}

}

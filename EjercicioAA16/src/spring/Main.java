package spring;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

	public static void main(String[] args) {
		try{
			AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Configuracion.class);
			Servicio servicio = ctx.getBean(Servicio.class);
			
			servicio.cargaTxts();
			servicio.generaArchivo();
			
		}catch(BeansException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

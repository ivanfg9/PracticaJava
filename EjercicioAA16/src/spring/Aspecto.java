package spring;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Aspecto {

	@Before("execution (* generaArchivo())") //No se muestra puesto que el método tiene parámetros
	public void generandoArchivo() {
		System.out.println("Se esta generando el nuevo archivo...");
	}
	
	@Before("execution (* cargaTxts())")
	public void verificandoExtension() {
		System.out.println("Verificación TXTs");
	}
	
	@After("execution (* generaArchivo())") //No se muestra puesto que el método tiene parámetros
	public void generandoSalida() {
		System.out.println("Se ha generado el nuevo archivo.");
	}
}

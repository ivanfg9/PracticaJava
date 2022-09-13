import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Random r = new Random();
		int numeroAleatorio = r.nextInt(1000000)+1;
		Usuario u = new Usuario("Iván");
		
		AdivinaNumero adivina = (n) -> {
			return numeroAleatorio == n;
		};
		
		int i = 1;
		System.out.print("Hola " + u.getNombre() + ", introduzca un número: ");
		int numero = scan.nextInt();
		while(i<5 && !u.adivinaElNumero(numero,adivina)) {
			System.out.print("No has acertado. Introduzca nuevamente un número: ");
			numero = scan.nextInt();
			i++;
		}
		
		if(i<5) {
			System.out.println("ADIVINASTE EL NÚMERO ENHORABUENAAA!!");
		}
		else {
			System.out.println("NO HAS CONSEGUIDO ADIVINAR EL NÚMERO. VUELVA A INTENTARLO LA PRÓXIMA VEZ!!");
		}
		
		scan.close();
	}
}

package picoplaca;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		//Scanner necesario para leer por pantalla
		Scanner teclado = new Scanner(System.in);
		
		//Se le pide al usuario ingresar el número de placa
		System.out.println("Introduzca la placa: ");
		String placa = teclado.nextLine();
		
		//Una vez la placa sea digitada correctamente se solicita el string de la fecha
		System.out.println("Introduzca la fecha con el formato dd/mm/yyyy: ");
		String fecha = teclado.nextLine();
		
		//Una vez la fecha sea digitada correctamente se solicita el string de la hora
		System.out.println("Introduzca la hora (HH:mm): ");
		String hora = teclado.nextLine();
		
		Placa inputsIngresados= new Placa(placa, fecha, hora);
		
		String resultado = inputsIngresados.afectaPicoPlaca();
		
		System.out.println(resultado);
		teclado.close();
	
	}
		
}

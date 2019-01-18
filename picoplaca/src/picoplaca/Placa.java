package picoplaca;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class Placa {

	private static String placa;
	private static String fecha;
	private static String hora;
	
	//Scanner necesario para leer por pantalla
	Scanner teclado = new Scanner(System.in);

	//constructor clase Placa
	public Placa(String ingresoTeclado1, String ingresoTeclado2, String ingresoTeclado3) {
		
		
		//While revisa que el String ingresado cumple los requisitos de placa, caso contrario vuelve a pedir
		while(validarPlaca(ingresoTeclado1)==-1) {
			System.out.println("La placa ingresada contiene errores, verifique e intente nuevamente: ");
			System.out.println("*Recuerde que la placa debe contener un número al final de la misma");
			ingresoTeclado1 = teclado.nextLine();
		}
		//Se valida que la fecha ingresada sea una fecha válida, caso contrario se vuelve a pedir
		while(!validarFecha(ingresoTeclado2)) {
			System.out.println("La fecha ingresada no es valida, verifique e intente nuevamente: ");
			System.out.println("*Recuerde que el formato de fecha debe ser dd/mm/yyyy ");
			ingresoTeclado2 = teclado.next();
		}
		//Se valida que la hora ingresada sea una hora válida, caso contrario se vuelve a pedir
		while(!validarHora(ingresoTeclado3)) {
			System.out.println("La hora ingresada no es valida, verifique e intente nuevamente: ");
			System.out.println("(Recuerde que el formato de hora debe ser (24 HORAS) HH:mm ");
			ingresoTeclado3 = teclado.next();
		}
		placa = ingresoTeclado1;
		fecha = ingresoTeclado2;
		hora = ingresoTeclado3;
	}

	//Método que me devuelve el último dígito de una placa que entra como un String si no es un número devuelve -1
	public int validarPlaca(String placaIngresada) {
		int lastNumber=-1;
		if(placaIngresada.length()>=6 && placaIngresada.length()<=7) {

			char lastCharacter=placaIngresada.charAt(placaIngresada.length()-1);
			boolean itIsANumber= Character.isDigit(lastCharacter);
			if(itIsANumber) {
				lastNumber= Character.getNumericValue(lastCharacter);
			}
		}
		return lastNumber;
	}

	//Método que me devuelve falso en caso de que el string ingresado no sea una fecha
	public boolean validarFecha(String fecha) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyy");
			LocalDate date = LocalDate.parse(fecha, formatter);
		}catch(DateTimeParseException e) {
			return false;
		}
		return true;
	}

	//Método que me devuelve falso en caso de que el string ingresado no sea una hora
		public boolean validarHora(String hora) {
			try {
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:mm");
				LocalTime date = LocalTime.parse(hora, formatter);
			}catch(DateTimeParseException e) {
				return false;
			}
			return true;
		}

		

		
		
	//Método que me devuelve el número del día en la semana que corresponde a una fecha ingresada
	public int dayOfWeek(String fecha) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/M/yyy");
		LocalDate date = LocalDate.parse(fecha, formatter);
		return date.getDayOfWeek().getValue();
	}

	


	//Método que toma como argumento un String y devuelve verdadero si es una hora dentro del rango de pico y placa
	//o devuelve falso si no es una hora o si no se encuentra dentro del rango de pico y placa
	public boolean dentroHorarioPicoPlaca(String horaIngresada){
		boolean estaDentroHorario= false;
		try {

			DateFormat dateF = new SimpleDateFormat("HH:mm");
			Date horaMañanaInicio = dateF.parse("7:00");
			Date horaMañanaFin= dateF.parse("9:30");


			Date horaTardeInicio = dateF.parse("16:00");
			Date horaTardeFin = dateF.parse("19:30");

			Date horaPrueba = dateF.parse(horaIngresada);

			if((horaPrueba.compareTo(horaMañanaInicio) >= 0 && horaPrueba.compareTo(horaMañanaFin) <= 0 ) || (horaPrueba.compareTo(horaTardeInicio) >= 0 && horaPrueba.compareTo(horaTardeFin) <= 0 )) {
				estaDentroHorario= true;
			}
		}catch(ParseException e) {
			System.out.println("La hora ingresada posee errores");
		}
		return estaDentroHorario;
	}
	
	public String afectaPicoPlaca() {
		String resultado = ""; 
		int validacionPlaca = validarPlaca(placa);
		if(dentroHorarioPicoPlaca(hora)) {
			switch(dayOfWeek(fecha)) {
			case 1:
				if(validacionPlaca==1 || validacionPlaca==2){
					//resultado = "De 7:00 a las 9:30 en la mañana y de 16:00 a 19:30 en la tarde el pico y placa afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa ESTÁ Afectando a tu vehículo";
				}else {
					//resultado = "El pico y placa NO afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa No está afecta a tu vehículo";
				}
				break;
			case 2:
				if(validacionPlaca==3 || validacionPlaca==4){
					//resultado = "De 7:00 a las 9:30 en la mañana y de 16:00 a 19:30 en la tarde el pico y placa afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa ESTÁ Afectando a tu vehículo";
				}else {
					//resultado = "El pico y placa NO afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa No está afecta a tu vehículo";
				}
				break;
			case 3:
				if(validacionPlaca==5 || validacionPlaca==6){
					//resultado = "De 7:00 a las 9:30 en la mañana y de 16:00 a 19:30 en la tarde el pico y placa afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa ESTÁ Afectando a tu vehículo";
				}else {
					//resultado = "El pico y placa NO afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa No está afecta a tu vehículo";
				}
				break;
			case 4:
				if(validacionPlaca==7 || validacionPlaca==8){
					//resultado = "De 7:00 a las 9:30 en la mañana y de 16:00 a 19:30 en la tarde el pico y placa afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa ESTÁ Afectando a tu vehículo";
				}else {
					//resultado = "El pico y placa NO afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa No está afecta a tu vehículo";
				}
				break;
			case 5:
				if(validacionPlaca==9 || validacionPlaca==0){
					//resultado = "De 7:00 a las 9:30 en la mañana y de 16:00 a 19:30 en la tarde el pico y placa afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa ESTÁ Afectando a tu vehículo";
				}else {
					//resultado = "El pico y placa NO afecta a tu vehículo el día de hoy";
					resultado = "\nEl pico y placa No está afecta a tu vehículo";
				}
				break;
			case 6: case 7: //case Feriado: falta tomar en cuenta los feriados para el programa
				//resultado = "El pico y placa NO APLICA los días sábados, domingos ni feriados";
				resultado = "\nEl pico y placa No está afecta a tu vehículo";
				break;
			}
		}else {
			resultado = "\nEl pico y placa No Afecta a tu vehículo";
		}
		return resultado;
		
	}
	
}

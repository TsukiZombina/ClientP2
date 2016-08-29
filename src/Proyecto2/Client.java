package Proyecto2;

import java.rmi.Naming;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

public class Client {

	public static void main(String[] args) {
		
		//Turismo
		ITurismo turismo;
		try {
			turismo = (ITurismo)Naming.lookup("rmi://localhost:1099/Turismo");
			System.out.println("5 dolares a pesos es: " + turismo.convertirDivisa(1, 5, 2) + " pesos");
			System.out.println("El clima en Paris es : " + turismo.getClima(1) + " grados");
			System.out.println("La hora aqu� es : " + Calendar.getInstance().get(Calendar.HOUR_OF_DAY));
			TimeZone tz = turismo.getHoraExacta(1);
			Calendar c = Calendar.getInstance(tz);
			System.out.println("La hora en paris es : " + c.get(Calendar.HOUR_OF_DAY));
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		IGeografico geografico;
		try {
			geografico = (IGeografico)Naming.lookup("rmi://localhost:1099/Geografico");
			System.out.println("La localizacion de la biblioteca es: " + geografico.ubicacionDe(1));
			Profesor prof = geografico.getDatosProfesor(1);
			System.out.println(prof.getNombre() + ", " + prof.getCubiculo() + ", " + prof.getCorreo() + ", " + prof.getTelefono());
			ArrayList<String> materias = geografico.materiasImpartidas(1);
			System.out.println(materias);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		IEntretenimiento entretenimiento;
		try {
			entretenimiento = (IEntretenimiento)Naming.lookup("rmi://localhost:1099/Entretenimiento");
			ArrayList<Funcion> funciones = entretenimiento.cinesYHorarios(1);
			System.out.println(funciones.get(0).getRecinto() + " " + funciones.get(1).getHoraInicio());
			System.out.println(entretenimiento.horarioMuseo(1));
			funciones = entretenimiento.costoPorFuncion(1);
			System.out.println(funciones.get(0).getRecinto() + " " + funciones.get(1).getCosto());
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

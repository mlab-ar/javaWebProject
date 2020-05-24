package baseDeDatos;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Fecha {
	public static Calendar calendar = Calendar.getInstance();
	private static String fecha;
	
	
	public Fecha() {
		// TODO Auto-generated constructor stub
	}
	
	public static String Fecha() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYY"); 
		fecha = sdf.format(calendar.getTime());
		return fecha;
	}
	
	public static String FechaBD() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-YYY"); 
		fecha = sdf.format(calendar.getTime());
		return fecha;
	}
	
}

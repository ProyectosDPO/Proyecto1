package procesamiento;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import consola.AplicacionAlquiler;
import modelo.Sede;

public class Archivo {
	//* Creo que es mas facil solo crear un atributo privado para cada archivo que vayamos a guardar
	
	public static Map<String, Sede> cargarMenu (String nombreArchivo) throws FileNotFoundException, IOException{
		Map<String, Sede> lasSedes = new HashMap<>();;
		
		BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
		String linea;
		String[] titulos = new String[]{"Precio", "Horario", "Disponible Room Service"};
		
		
		linea = br.readLine();
		linea = br.readLine();
		while (linea != null) {
			String[] partes = linea.split(";");
			String nombreSede = partes[0];
			String UbicacionSede = partes[1];
			String HorariosSede = partes[2];
			int IntSede = Integer.parseInt(partes[3]);
			Sede nuevaSede = new Sede(nombreSede,UbicacionSede,HorariosSede,IntSede);
			
			linea = br.readLine();
			lasSedes.put(nombreSede, nuevaSede);
		}
		br.close();
		
		
		
		
		return lasSedes;
	}

}

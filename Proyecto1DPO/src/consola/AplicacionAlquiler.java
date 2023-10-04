package consola;
import modelo.Sede;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.Cliente;
import modelo.Empleado;
import procesamiento.Archivo;
import procesamiento.Reserva;



public class AplicacionAlquiler {
	
	Map<String, Sede> sedeMap = new HashMap<>();
	Map<String, Cliente> ClienteMap = new HashMap<>();
	Map<String, String> EmpleadoMap = new HashMap<>();
	Map<String, Reserva> ReservasClientes = new HashMap<>();
	
	
	
	public void opcionesUsuario()
	{System.out.println("1.Cargar datos\n2.Menu Clientes\n3.Menu Sede\n4.Menu empleado\n"
			+ "5.Por definir\n6.Por definir\n7.Por definir\n8.Por definir\n9.Salir\n");}
	
	
	
	public void ejecutar_aplicacion()
	{

	boolean continuar = true;
	
	while (continuar)
		
	
	{
		System.out.println("\n\n-------------Opciones de usuario-------------\n\n");
		opcionesUsuario();
		int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
	 if (opcion_seleccionada ==1) 
	 	{System.out.println("Opcion 1: Cargar Archivos de la compañia");}	
	 if (opcion_seleccionada ==2) 
	 	{System.out.println("Opcion 2:  Menu Clientes");
	 	Cliente funcionesCliente = new Cliente(null, null, null, null, null);
	 	funcionesCliente.ejecutarCliente(ClienteMap,ReservasClientes,sedeMap);}
	 
	 if (opcion_seleccionada ==3) 
	 	{System.out.println("Opcion 3:  Menu Sede");
	 	Sede funcionesSede = new Sede(null, null, null, opcion_seleccionada);
	 	funcionesSede.ejecutarSede(sedeMap);
	 	}	
	 if (opcion_seleccionada ==4) 
	 	{System.out.println("Opcion 4:  Menu Empleado");
	 	Empleado funcionesEmpleado = new Empleado(null, null);
	 	funcionesEmpleado.ejecutarEmpleado(EmpleadoMap);
	 	}
	 if (opcion_seleccionada ==5) 
	 	{System.out.println("Opcion 5:  9 se sale de la app");
	 	}	
	 if (opcion_seleccionada ==6) 
	 	{System.out.println("Opcion 6:  9 se sale de la app");
	 	}
	 	
	 if (opcion_seleccionada ==7) 
	 	{System.out.println("Opcion 7:  9 se sale de la app");
	 	String sd= (input("Nombre de la sede -> "));
	 	Sede arrendada = sedeMap.get(sd);
	 	arrendada.ArrendamientoUnCarro();
	 	sedeMap.put(sd, arrendada);
	 	}
	 if (opcion_seleccionada ==8) 
	 	{System.out.println("Opcion 8:  9 se sale de la app");}
	 if (opcion_seleccionada ==9) 
	 	{System.out.println("Saliendo de la app...\n\n...");
		 continuar=false;}
	}}
	

	
	

	public static void main(String[] args) {
		System.out.println("APLICACION DE ALQUILER DE VEHICULOS\n\n");
		AplicacionAlquiler Ejecutador = new AplicacionAlquiler();
		Ejecutador.ejecutar_aplicacion();

	}
	
	
	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;

}

}

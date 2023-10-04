package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import modelo.InventarioVehiculo;

public class Empleado {
	private String nombre;
	private String cargo;
	
	
	
	public Empleado(String elnombre, String elcargo) {
		this.nombre = nombre;
		this.cargo = cargo;
	}

	public void PrintmenuEmpleado() {
		{
			System.out.println("1.Crear nuevo empleado\n2.Buscar empleado\n3.Eliminar empleado"
					+ "\n4.Mostrar todos los empleados\n" + "5.Por definir\n6.Por definir\n7.Por Definir"
					+ "\n8.Por definir\n9.Salir al Menu principal\n");
		}
		
	}
	
	
	public void NuevoEmpleado(Map<String, String> EmpleadoMap) {
		String elnombre = (input("Nombre del empleado -> "));
		String elcargo = (input("Cargo Empleado "));
		EmpleadoMap.put(elnombre, elcargo);
		System.out.println("Se ha guardado exitosamente el empleado, para buscarlo use su numero de identidad");
	}
	
	public void BuscarEmpleado(Map<String, String> EmpleadoMap) {
		String elnombre= (input("Ingrese el nombre del empleado -> "));
		if (EmpleadoMap.containsKey(elnombre)){
			System.out.println("Nombre empleado: " +elnombre);
			System.out.println("Numero de contacto: " + EmpleadoMap.get(elnombre));
			System.out.println("\n+--------------------------------------+\n");
		}
		else {
			System.out.println("Empleado no se ha encontrado");
		}	
	}
	
	public void EliminarEmpleado(Map<String, String> EmpleadoMap) {
		String eldocumento= (input("Ingrese el nombre del empleado -> "));
		if (EmpleadoMap.containsKey(eldocumento)) {
			EmpleadoMap.remove(eldocumento);

		} else {
			System.out.println("No se ha encontrado la sede que desea buscar");
		}
	}
	
	

	public void ejecutarEmpleado(Map<String,String>EmpleadoMap) {
		boolean continuar = true;
		while (continuar) {

			System.out.println("\n\n-------------Opciones de usuario-------------\n\n");
			PrintmenuEmpleado();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				System.out.println("Opcion 1: Crear nuevo empleado");
				NuevoEmpleado(EmpleadoMap);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Empleado Creado. Click para continuar"));
			}
			if (opcion_seleccionada == 2) {
				System.out.println("Opcion 2:  Buscar Empleado");
				BuscarEmpleado(EmpleadoMap);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 3) {
				System.out.println("Opcion 3:  Eliminar Empleado");
				EliminarEmpleado(EmpleadoMap);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Empleado Eliminado.Click para continuar"));
			}
			if (opcion_seleccionada == 4) {
				System.out.println("Opcion 4:  Empleados Actuales");
				showEmpleados(EmpleadoMap);
				@SuppressWarnings("unused")
				String hacertiempo = (input("Click para continuar"));
				
			}
			if (opcion_seleccionada == 5) {
				System.out.println("Opcion 5:  Por definir");
				
			}
			if (opcion_seleccionada == 6) {
				System.out.println("Opcion 6:  Por definir");
			}

			if (opcion_seleccionada == 7) {
			}
			if (opcion_seleccionada == 8) {
				System.out.println("Opcion 8:  Por definir");
			}
			if (opcion_seleccionada == 9) {
				System.out.println("Saliendo de la app...\n\n...");
				continuar = false;
			}

		}
	}
	
	
	public void showEmpleados(Map<String, String> EmpleadoMap) {
		System.out.println("\nSEDES ACTUALES: \n\n+--------------------------------------+\n");
		for (Map.Entry<String, String> entry : EmpleadoMap.entrySet()) {
			String busqueda = entry.getValue();
			System.out.println("\n+--------------------------------------+\n");
			System.out.println("Nombre Empleado: " + entry.getKey());
			System.out.println("Cargo Empleado: " + busqueda);
			System.out.println("\n+--------------------------------------+\n");

		}}
	
	
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

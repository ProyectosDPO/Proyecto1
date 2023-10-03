package modelo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;

public class Sede {
	private String nombre;
	private String ubicacion;
	private String horariosAtencion;
	private ArrayList<String> empleados;
	private int cantidadVehiculos;

	public Sede(String elNombre, String laUbicacion, String loshorariosAtencion, int lacantidadVehiculos) {
		this.nombre = elNombre;
		this.ubicacion = laUbicacion;
		this.horariosAtencion = loshorariosAtencion;
		this.empleados = new ArrayList<String>();
		this.cantidadVehiculos = lacantidadVehiculos;

	}

	public void setCantidadVehiculos(int cantidadVehiculos) {
		this.cantidadVehiculos = cantidadVehiculos;
	}

	public void ArrendamientoUnCarro() {
		if (cantidadVehiculos > 0) {
			cantidadVehiculos--;
		}
	}

	public String darNombre() {
		return nombre;
	}

	public String darUbicacion() {
		return ubicacion;
	}

	public String darHorario() {
		return horariosAtencion;
	}

	public int darcantidadVehiculos() {
		return cantidadVehiculos;
	}

	public void NuevaSede(Map<String, Sede> sedeMap) {

		String elnombre = (input("Nombre de la sede -> "));
		String laubicacion = (input("Ubicacion de la sede -> "));
		String losHorarios = (input("Horario Atencion -> "));
		int lacantidadVehiculos = Integer.parseInt(input("Cantidad de vehiculos ->"));
		Sede nuevasede = new Sede(elnombre, laubicacion, losHorarios, lacantidadVehiculos);
		sedeMap.put(elnombre, nuevasede);

	}

	public void ejecutarSede(Map<String, Sede> sedeMap) {
		boolean continuar = true;
		while (continuar) {

			System.out.println("\n\n-------------Opciones de usuario-------------\n\n");
			PrintmenuSede();
			int opcion_seleccionada = Integer.parseInt(input("Por favor seleccione una opción"));
			if (opcion_seleccionada == 1) {
				System.out.println("Opcion 1: Crear nueva sede");
				NuevaSede(sedeMap);
			}
			if (opcion_seleccionada == 2) {
				System.out.println("Opcion 2:  Consultar sedes");
				showSede(sedeMap);
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 3) {
				System.out.println("Opcion 3:  Modificar Invenatrio vehiculos Sede");
				ModificarInvenatrioVehiculos(sedeMap);
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 4) {
				System.out.println("Opcion 4:  Sede especifica");
				SedeEspecifica(sedeMap);
				String hacertiempo = (input("Click para continuar"));
			}
			if (opcion_seleccionada == 5) {
				System.out.println("Opcion 5:  Eliminar sede");
				Eliminarsede(sedeMap);
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

	public void Eliminarsede(Map<String, Sede> sedeMap) {
		String elnombre = (input("Nombre de la sede -> "));
		if (sedeMap.containsKey(elnombre)) {
			sedeMap.remove(elnombre);

		} else {
			System.out.println("No se ha encontrado la sede que desea buscar");
		}
	}

	public void PrintmenuSede() {

		{
			System.out.println("1.Crear nueva Sede\n2.Consultar Sedes\n3.Modificar Inventario de vehiculos Sede"
					+ "\n4.Ver datos Sede especifica\n" + "5.Eliminar Sede\n6.Por definir\n7.Por Definir"
					+ "\n8.Por definir\n9.Salir al Menu principal\n");
		}

	}

	public void SedeEspecifica(Map<String, Sede> sedeMap) {
		String elnombre = (input("Nombre de la sede -> "));
		Sede sede = sedeMap.get(elnombre);
		System.out.println("\n+--------------------------------------+\n");
		System.out.println("Nombre Sede: " + sede.darNombre());
		System.out.println("Ubicacion Sede: " + sede.darUbicacion());
		System.out.println("Horario Sede: " + sede.darHorario());
		System.out.println("Vehiculos Disponibles: " + sede.darcantidadVehiculos());
		System.out.println("\n+--------------------------------------+\n");

	}

	public void ModificarInvenatrioVehiculos(Map<String, Sede> sedeMap) {
		String elnombre = (input("Nombre de la sede -> "));
		if (sedeMap.containsKey(elnombre)) {
			Sede modificar = sedeMap.get(elnombre);
			int nuevaCantidad = Integer.parseInt(input("Cantidad de vehiculos ->"));
			modificar.setCantidadVehiculos(nuevaCantidad);
			sedeMap.put(elnombre, modificar);
		}
		else {
			System.out.println("No se ha encontrado la sede que desea buscar");
		}

	}

	public void showSede(Map<String, Sede> sedeMap) {
		System.out.println("\nSEDES ACTUALES: \n\n+--------------------------------------+\n");
		for (Map.Entry<String, Sede> entry : sedeMap.entrySet()) {
			Sede sede = entry.getValue();
			System.out.println("Nombre Sede: " + sede.darNombre());
			System.out.println("Ubicacion Sede: " + sede.darUbicacion());
			System.out.println("Horario Sede: " + sede.darHorario());
			System.out.println("Vehiculos Disponibles: " + sede.darcantidadVehiculos());
			System.out.println("\n+--------------------------------------+\n");

		}
	}

	public ArrayList<String> darEmpleados() {
		return empleados;
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

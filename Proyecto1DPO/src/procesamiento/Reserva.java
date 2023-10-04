package procesamiento;

import modelo.Sede;
import modelo.MedioPago;
import procesamiento.Archivo;
import modelo.Cliente;
import modelo.Vehiculo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import modelo.CategoriaVehiculo;

public class Reserva {

	private String categoria;
	private String fechaRecogido;
	private int duracion;
	private String sedeInicial;
	private String sedeFinal;
	private String segurosIncluidos;
	private int conductoresAdicionales;

	public Reserva(String categoria, String fechaRecogido, int duracion, String sedeInicial, String sedeFinal,
			String segurosIncluidos, int conductoresAdicionales) {
		this.categoria = categoria;
		this.fechaRecogido = fechaRecogido;
		this.duracion = duracion;
		this.sedeInicial = sedeInicial;
		this.sedeFinal = sedeFinal;
		this.segurosIncluidos = segurosIncluidos;
		this.conductoresAdicionales = conductoresAdicionales;

	}

	public void NuevaReserva(Map<String, Reserva> ReservasClientes, Map<String, Cliente> ClienteMap,
			Map<String, Sede> sedeMap) {
		String elnombre = (input("Ingrese cedula del cliente para la reserva-> "));

		if (ClienteMap.containsKey(elnombre)) {
			String lacategoria = (input("Ingrese la categoria que se busca de la reserva-> "));
			String lafechaRecogido = (input("Ingrese la fecha de la reserva-> "));
			int laduracion = Integer.parseInt(input("Indique duracion -> "));
			String lasedeInicial = (input("Ingrese sede donde desea recoger el carro-> "));
			String lasedeFinal = (input("Ingrese sede donde desea dejar el carro-> "));
			String losseguros = (input("Indique que seguros desea tomar separados por un \'-\' -> "));
			int losconductores = Integer.parseInt(input("Indique cuantos conductores adicionales va a tener: "));
			Reserva nuevareserva = new Reserva(lacategoria,lafechaRecogido,laduracion,lasedeInicial,lasedeFinal,losseguros,losconductores);
			boolean hayCarros = checkSede(sedeMap,lasedeInicial);
			if(hayCarros) {ReservasClientes.put(elnombre, nuevareserva);}
			
		}

		else {
			System.out.println("No se ha encontrado el cliente, " + "favor registrarlo en la seccion de clientes");
		}
	}

	public void EliminarReserva(Map<String, Reserva> ReservasClientes) {
		String elnombre = (input("Cedula bajo la que se encuentra la reserva: "));
		if (ReservasClientes.containsKey(elnombre)) {
			ReservasClientes.remove(elnombre);
			System.out.println("La reserva se ha cancelado exitosamente");

		} else {
			System.out.println("No se ha encontrado la reserva que desea buscar");
		}
	}

	public String getCategoria() {
		return categoria;
	}

	public String getFechaRecogido() {
		return fechaRecogido;
	}

	public int getDuracion() {
		return duracion;
	}

	public String getSedeInicial() {
		return sedeInicial;
	}

	public String getSedeFinal() {
		return sedeFinal;
	}

	public String getSegurosIncluidos() {
		return segurosIncluidos;
	}

	public int getConductoresAdicionales() {
		return conductoresAdicionales;
	}

	public void showReservas(Map<String, Reserva> ReservasClientes) {
		System.out.println("\nRESERVAS ACTUALES: \n\n+--------------------------------------+\n");
		for (Map.Entry<String, Reserva> entry : ReservasClientes.entrySet()) {
			Reserva busqueda = entry.getValue();
			System.out.println("\n+--------------------------------------+\n");
			System.out.println("Cedula Cliente: " + entry.getKey());
			System.out.println("Categoria Vehiculo: " + busqueda.getCategoria());
			System.out.println("Fecha Sacado: " + busqueda.getFechaRecogido());
			System.out.println("Duracion de la reserva: " + busqueda.getDuracion());
			System.out.println("Sede donde fue recogido: " + busqueda.getSedeInicial());
			System.out.println("Sede donde va a ser entregado: " + busqueda.getSedeFinal());
			System.out.println("Seguros Incluidos: " + busqueda.getSegurosIncluidos());
			System.out.println("Conductores adicionales: " + busqueda.getConductoresAdicionales());
			System.out.println("\n+--------------------------------------+\n");

		}
	}

	public Boolean checkSede(Map<String, Sede> sedeMap, String nombresede) {

		if (sedeMap.containsKey(nombresede)) {
			Sede sedeInventario = sedeMap.get(nombresede);
			if (sedeInventario.darcantidadVehiculos() > 0) {
				sedeInventario.ArrendamientoUnCarro();
				return true;
			} else {
				System.out.println("No hay vehiculos en el inventario para cumplir con la reserva");
				return false;
			}
		}

		else {
			System.out.println("La sede que busca no se ha encontrado");
			return false;
		}
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

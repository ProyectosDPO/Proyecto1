package modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import modelo.Empleado;
import modelo.Vehiculo;
import procesamiento.Archivo;

public class Sede {
	private String nombre;
	private String ubicacion;
	private String horariosAtencion;
	private ArrayList<String> empleados;
	private int cantidadVehiculos;
	
	public Sede(String elNombre, String laUbicacion, String loshorariosAtencion)
	{
		this.nombre = elNombre;
		this.ubicacion = laUbicacion;
		this.horariosAtencion=loshorariosAtencion;
		this.empleados= new ArrayList<String>();

	}
	
	public String darNombre()
	{
		return nombre;
	}
	
	public String darUbicacion()
	{
		return ubicacion;
	}
	
	public String darHorario()
	{
		return horariosAtencion;
	}
	
	public void showSede(List<Sede> sedeList) 
	{
		System.out.println("\nSEDES ACTUALES: \n\n+--------------------------------------+\n");
		for (Sede sede : sedeList) {
            System.out.println("Nombre Sede: " + sede.darNombre());
            System.out.println("Ubicacion Sede: " + sede.darUbicacion());
            System.out.println("Horario Sede: " + sede.darHorario());
            System.out.println("\n+--------------------------------------+\n");
        }
		
	}
	
	public ArrayList<String> darEmpleados()
	{
		return empleados;
	}
}

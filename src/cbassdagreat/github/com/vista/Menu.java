package cbassdagreat.github.com.vista;

import java.util.List;
import java.util.Scanner;

import cbassdagreat.github.com.modelo.Cliente;
import cbassdagreat.github.com.modelo.Estado;
import cbassdagreat.github.com.modelo.ExportarTxt;
import cbassdagreat.github.com.servicios.ClienteServicio;

public class Menu {

		
	private Scanner sc;
	ClienteServicio cs;
	ExportarTxt et;
	
	public Menu() {
		sc = new Scanner(System.in);
		cs = new ClienteServicio();
		et = new ExportarTxt();
	}
	
	public void generarMenu() {
		int opcion = 0;
		
		do {
			System.out.println("Menu\n1) Listar Clientes\n2) Agregar Cliente\n3) Editar Cliente\n4) Cargar Datos\n5) Exportar Datos\n6) Salir\nIngrese una opción:\n");
			opcion = sc.nextInt();
			
			switch (opcion) {
			case 1:
				listar();
				break;
			case 2:
				agregar();
				break;
			case 3:
				editar();
				break;
			case 4:
				importar();
				break;
			case 5:
				exportar();
				break;
			case 6:
				salir();
				break;
			default: System.out.println("Opción no válida");
			
			}
		} while (opcion!=6);
	}
	
	public Cliente agregar() {

		System.out.println("------Crear Cliente------");
		System.out.println("Ingrese RUN del Cliente:");
		String run = sc.next();
		
		System.out.println("Ingrese Nombre del Cliente:");
		//sc.nextLine();
		String nombre = sc.next();
		
		System.out.println("Ingrese Apellido del Cliente:");
		//sc.nextLine();
		String apellido = sc.next();
				
		System.out.println("Ingrese años como Cliente:");
		//sc.next();
		String anios = sc.next();
		
		Estado categoria = Estado.Activo;
		
		Cliente c = new Cliente (run, nombre, apellido, anios, categoria);
		
		try {
			cs.agregarCliente(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return c;
		
		
	}

	private void importar() {
		System.out.println("Importar Datos");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo\r\nDBClientes.csv:");
		String ruta = sc.next();
		List<Cliente> nuevos = et.importar(ruta);
		if(nuevos!=null) {
			for (Cliente c : nuevos) {
				try {
					cs.agregarCliente(c);
					System.out.println("Datos cargados correctamente en la lista");
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		else {
			System.out.println("No hay elementos para importar");
		}
	}
	
	private void exportar() {
		System.out.println("---------Exportar Datos---------");
		System.out.println("Seleccione el formato a exportar:");
		System.out.println("1.- Formato csv\n2.- Formato txt\nIngrese una opción:\n");
		int option = sc.nextInt();
		if (option == 1) {
			System.out.println("Ingrese la ruta en donde desea exportar el archivo clientes.csv:");
			String ruta = sc.next();
			et.exportar(cs.getListaClientes(), ruta);
		}
		else if(option == 2) {
			System.out.println("Ingrese la ruta en donde desea exportar el archivo clientes.txt:");
			String ruta = sc.next();
			et.exportar(cs.getListaClientes(), ruta);
		}
		else {
			System.out.println("Selección incorrecta");
		}
	}

	private void salir() {
		System.out.println("Saliendo del sistema");
		System.out.println("Ha salido del sistema");
	}
	
	private void listar() {
		try {
			cs.listarClientes();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void editar() {
		
		
		System.out.println("---------Editar Cliente---------\nSeleccione qué desea hacer:\n1.- Cambiar el estado del Cliente\n2.- Cambiar los datos ingresados del Cliente\nIngrese Opción:\n");
		System.out.println("------------------------");
		int opcion = sc.nextInt();
		if(opcion == 1) {
			System.out.println("Ingrese el RUN del Cliente a editar");
			String run1 = sc.next();
			Cliente c1 = cs.buscarRun(run1);
			if (c1!=null) {
				System.out.printf("-----Actualizando Estado del Cliente------\nEl estado actual es : %s\n", c1.getEstado());
				System.out.println("1.-Si desea cambiar el estado del Cliente a Inactivo\n2.-Si desea cambiar el estado del Cliente a Activo\nIngrese Opción\n--------------------------------------");
					int categoria = sc.nextInt();
					if (categoria == 1) {
					//Estado categoria1 = Estado.Inactivo;
						c1.setEstado(Estado.Inactivo);
					System.out.printf("Estado Cliente %s:\n" , c1.getEstado());
					}
					else if(categoria == 2) {
						//categoria = sc.nextInt();
					//Estado estado = Estado.Activo;
						c1.setEstado(Estado.Activo);
					System.out.printf("Estado Cliente es %s\n" , c1.getEstado());
					}
				
		
		
		
		
	}
}
		else if(opcion == 2) {
			System.out.println("Ingrese el RUN del cliente");
			String run = sc.next();
			Cliente c = cs.buscarRun(run);
			if (c!=null) {
				System.out.printf("1.- RUN del Cliente: %s \n", c.getRun());
				System.out.printf("2.- Nombre del Cliente: %s \n", c.getNombre());
				System.out.printf("3.- Apellido del Cliente: %s \n", c.getApellido());
				System.out.printf("4.- Años como Cliente: %s años \n", c.getAnios());
				System.out.printf("5.- Categoría del Cliente: %s \n", c.getEstado());
				
				System.out.println("Ingrese la opción a modificar");
				
				int alternativa = sc.nextInt();
				
				switch (alternativa) {
				case 1:
					System.out.println("Ingresa el nuevo RUN");
					String rut = sc.next();
					c.setRun(rut);
					break;
				case 2:
					System.out.println("Ingresa el nuevo Nombre del Cliente");
					sc.nextLine();
					String nombre = sc.nextLine();
					
					c.setNombre(nombre);
						break;
				
				case 3:
					System.out.println("Ingresa el nuevo Apellido del Cliente");
					sc.nextLine();
					String apellido = sc.nextLine();
					
					c.setApellido(apellido);
			 
						break;
					
				
				case 4:
					System.out.println("Ingresa los nuevos años del Cliente");
					sc.nextLine();
					String anios = sc.nextLine();
					
					c.setAnios(anios);
						break;
						
					default:
						System.out.println("Alternativa no válida");
						break;
				}
							
			}
		}
		else {
			System.out.println("No existe un Cliente con ese RUN");
		}
		}
		}

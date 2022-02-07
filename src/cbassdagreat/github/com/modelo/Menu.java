package cbassdagreat.github.com.modelo;

import java.util.List;
import java.util.Scanner;

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
			System.out.println("Menu\n1)Listar Clientes\n2) Agregar Cliente\n3) Editar Cliente\n4) Cargar Datos\n5) Exportar Datos\n6) Salir\nIngrese una opción:\n");
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
	
	private void importar() {
		System.out.println("Importar Datos");
		System.out.println("Ingresa la ruta en donde se encuentra el archivo\r\nDBClientes.cvs:");
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
			System.out.println("Ingrese la ruta en donde desea exportar el archivo clientes.txt: ");
		}
		else {
			System.out.println("Selección incorrecta");
		}
	}

}

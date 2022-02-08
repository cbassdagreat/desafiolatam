package cbassdagreat.github.com.servicios;
import java.util.ArrayList;
import java.util.List;

import cbassdagreat.github.com.modelo.Cliente;
import cbassdagreat.github.com.vista.Menu;


public class ClienteServicio {
	
	private List<Cliente> listaClientes;

	public ClienteServicio(List<Cliente> listaClientes) {
		super();
		this.listaClientes = listaClientes;
	}
	
	public ClienteServicio() {
		listaClientes = new ArrayList<>();
	}

	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	

	@Override
	public String toString() {
		return "ClienteServicio [listaClientes=" + listaClientes + "]";
	}
	
	
	public Cliente buscarRun(String run) {
		for(Cliente cliente:listaClientes) {
			if(cliente.getRun().equals(run)) {
				return cliente;
			}
		}
		return null;
	}
	
	public void agregarCliente(Cliente c) throws Exception{
//		Menu menu = new Menu();
//		c = menu.agregar();
		if(buscarRun(c.getRun())==null) {
			listaClientes.add(c);
			System.out.println("Cliente agregado");
			}
		
		else {
			throw new Exception("El Run ingresado ya existe");
		}
		
	}
		public void listarClientes() {
			listaClientes.stream().forEach(System.out::print);
			
		}
	}

	



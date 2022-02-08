package cbassdagreat.github.com.modelo;

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cbassdagreat.github.com.servicios.ClienteServicio;

public class ExportarTxt extends ExportadorTxt {

	@Override
	public void exportar(List<Cliente> listaClientes, String ruta) {
		// TODO Auto-generated method stub
		String path = String.format("%s/clientes.csv", ruta);
		String path1 = String.format("%s/clientes.txt", ruta);
		File file = new File(path);
		
		if (file.exists()) {
			try {
				FileWriter fw = new FileWriter(file);
				BufferedWriter bw = new BufferedWriter(fw);
				for(Cliente cliente : listaClientes) {
					String c = String.format("%s,%s,%s,%s,%s", cliente.getRun(), cliente.getNombre(), cliente.getApellido(), cliente.getAnios(), cliente.getEstado());
					bw.write(c);
					bw.newLine();
					}
					bw.close();
		
			}
			catch (IOException ex) {
				System.out.println(ex.getMessage());

		}
			
		
	}	else if (!file.exists()) {
		
		try {
			file.createNewFile();
			FileWriter fw = new FileWriter(file);
			BufferedWriter bw = new BufferedWriter(fw);
			for(Cliente cliente : listaClientes) {
				String c = String.format("%s,%s,%s,%s,%s", cliente.getRun(), cliente.getNombre(), cliente.getApellido(), cliente.getAnios(), cliente.getEstado());
				bw.write(c);
				bw.newLine();
				}
				bw.close();
				
				System.out.println("Archivo Creado");
	
		}
		
		
		catch (IOException ex) {
			System.out.println(ex.getMessage());

	}
		
	}
			else {
				System.out.println("Ruta incorrecta");
				
			}
			
	}
	
	public List<Cliente> importar(String ruta){
		List<Cliente> lista = new ArrayList<>();
		String path = String.format("%s/DBClientes.csv" , ruta);
		File file = new File(path);
		if (file.exists()) {
			try {
				FileReader fr = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				
				String data = br.readLine();
				while(data !=null) {
					String[] datos = data.split(",");
					
				Cliente c = new Cliente();
				c.setRun(datos[0]);
				c.setNombre(datos[1]);
				c.setApellido(datos[2]);
				c.setAnios(datos[3]);
				//String a = datos[4].replace(""",);
				//String dato4 = datos[4];
				//System.out.println(datos[4]);
				
				if(datos[4].equals("Activo")){
					c.setEstado(Estado.Activo);
								
				}
				
				else if(datos[4].equals("Inactivo")) {
					c.setEstado(Estado.Inactivo);
				}
				
				else {
					c.setEstado(Estado.Inactivo);
				}
									
				lista.add(c);
				data = br.readLine();
				}
				
				br.close();
			}
			catch (FileNotFoundException ex) {
				System.out.println(ex.getMessage());
			}
			catch (IOException e) {
				System.out.println(e.getMessage());
			}
		}
		
		else {
			System.out.println("Ruta incorrecta");
			return null;
		}
		return lista;
	}

}	
package cbassdagreat.github.com.tests;

import static org.junit.Assert.assertNotNull;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;
import java.util.logging.Logger;

import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

import cbassdagreat.github.com.modelo.Cliente;
import cbassdagreat.github.com.modelo.Estado;
import cbassdagreat.github.com.servicios.ClienteServicio;

@DisplayName("Prueba de Cliente Servicio")
public class ClienteServicioTest {
	
	private static ClienteServicio servicio = new ClienteServicio();
	
	private static Cliente c = new Cliente("9.980.848-9","Sebastián","Clavería","10",Estado.Activo); 

	//private static Logger logger;
	
//	@BeforeAll
//	public static void setup() {
//		//servicio = new ClienteServicio();
//		
//	}
	
	@BeforeEach
	public void init() {
		
		servicio.getListaClientes().clear();
		
		
		
//		logger = Logger.getLogger("cbassdagreat.github.com.ClienteServicio");
//		logger.info("Before Each");
	}
	
	@Test
	public void testAgregarCliente(){
		
//		logger.info("Test agregar Cliente");
		//Cliente c = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
		boolean esperado = true;
		boolean obtenido = false;
		try {
			obtenido = servicio.agregarCliente(c);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testAgregarCienteDuplicado() throws Exception {
//		logger.info("Test Agregar Cliente Duplicado");
		//Cliente c = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
		Cliente c2 = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
		try {
			servicio.agregarCliente(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Cliente c = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
		boolean esperado = true;
		boolean obtenido = false;
		try {
			obtenido = servicio.agregarCliente(c2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		assertNotNull(obtenido, "El RUN ingresado ya existe");
	}
//	
////	@Test
////	public void testAgregarNull() {
////		String esperado = ""
////	}
//	
//	@Test
//	public void testExportar() {
//		String esperado = "Archivo Creado";
//		String obtenido = servicio.exportar();
//		assertEquals(esperado, obtenido);
//	}
//	@Test
//	
//	public void testImportar() {
//		//Cliente c = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
//		String esperado = "Cliente agregado";
//		String obtenido = servicio.agregarCliente(c);
//		assertEquals(esperado, obtenido);
	}

//	@Test
//	public void testListarClientes() {
//		List obtenido = servicio.listarClientes();
//		assertNotNull(obtenido);
//	}
//}

package cbassdagreat.github.com.tests;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
	
	private static ClienteServicio servicio;
	//private static Logger logger;
	
	@BeforeAll
	public static void setup() {
		servicio = new ClienteServicio();
	}
	
	@BeforeEach
	public void init() {
		
		servicio.getListaClientes().clear();
		
		
		
//		logger = Logger.getLogger("cbassdagreat.github.com.ClienteServicio");
//		logger.info("Before Each");
	}
	
	@Test
	public void testAgregarCliente(){
		
//		logger.info("Test agregar Cliente");
		Cliente c = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
		Boolean esperado = true;
		Boolean obtenido = null;
		try {
			obtenido = servicio.agregarCliente(c);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		assertEquals(esperado, obtenido);
	}
	
	@Test
	public void testAgregarCienteDuplicado() {
//		logger.info("Test Agregar Cliente Duplicado");
		Cliente c1 = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
		Cliente c2 = new Cliente ("9.980.848-9","Sebastián","Clavería","10",Estado.Activo);
		try {
			servicio.agregarCliente(c1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Boolean esperado = true;
		Boolean obtenido = null;
		try {
			obtenido = servicio.agregarCliente(c2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		assertEquals(esperado, obtenido);
	}
	
//	@Test
//	public void testAgregarNull() {
//		String esperado = ""
//	}
	
	@Test
	public void testExportar() {
		String esperado = "";
		String obtenido = "";
		assertEquals(esperado, obtenido);
	}
	@Test
	public void testImportar() {
		String esperado = "";
		String obtenido = "";
		assertEquals(esperado, obtenido);
	}

//	@Test
//	public void testListarClientes() {
//		List obtenido = servicio.listarClientes();
//		assertNotNull(obtenido);
//	}
}

package cbassdagreat.github.com.utilidades;

public class Utilidad {

	public static void limpiar() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 10;i++) {
			System.out.println("");
		}

	}
	
	public static void esperar() {
		try {
			Thread.sleep(2500);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

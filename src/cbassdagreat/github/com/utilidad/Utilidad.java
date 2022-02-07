package cbassdagreat.github.com.utilidad;

public class Utilidad {

	public static void limpiar() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 100;i++) {
			System.out.println("");
		}

	}
	
	public static void esperar() {
		try {
			Thread.sleep(5000);
		} 
		catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}

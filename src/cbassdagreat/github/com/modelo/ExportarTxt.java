package cbassdagreat.github.com.modelo;

import java.io.File;
import java.util.List;

public class ExportarTxt extends ExportadorTxt {

	@Override
	public void exportar(List<Cliente> listaClientes, String ruta) {
		// TODO Auto-generated method stub
		String path = String.format("%s/DBClientes.csv", ruta);
		File file = new File(path);
		
		if (file.exists()) {
			try {
				FileWriter fw = new FileWriter(file, true);
				BufferedWriter bw = new BufferedWriter(fw);
				for(Cliente cliente : listaClientes) {
					String c = String.format("%s,%s,%s,%s,%s,%s,%s", cliente.)
				}
			}
		}
		
	}

}

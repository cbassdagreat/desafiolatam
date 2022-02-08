package cbassdagreat.github.com.modelo;

public class Cliente {

	public String run;
	public String nombre;
	public String apellido;
	public String anios;
	public Estado estado;
	
	
	
	public Cliente() {
		super();
	}





	public Cliente(String run, String nombre, String apellido, String anios, Estado estado) {
		super();
		this.run = run;
		this.nombre = nombre;
		this.apellido = apellido;
		this.anios = anios;
		this.estado = estado;
	}
	
	

	

	public String getRun() {
		return run;
	}



	public void setRun(String run) {
		this.run = run;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getApellido() {
		return apellido;
	}



	public void setApellido(String apellido) {
		this.apellido = apellido;
	}



	public String getAnios() {
		return anios;
	}



	public void setAnios(String anios) {
		this.anios = anios;
	}



	public Estado getEstado() {
		return estado;
	}



	public void setEstado(Estado datos) {
		this.estado = datos;
	}


	

	@Override
	public String toString() {
		
		StringBuilder sb = new StringBuilder();
		sb.append(String.format("Run Cliente : %s \n" , getRun()));
		sb.append(String.format("Nombre Cliente : %s \n" , getNombre()));
		sb.append(String.format("Apellido Cliente : %s \n" , getApellido()));
		sb.append(String.format("Años Cliente : %s \n" , getAnios()));
		sb.append(String.format("Categoría del Cliente : %s \n" , getEstado()));
		sb.append(String.format("----------------------\n"));
				
		
		return sb.toString();
	}

	
	
	

	}



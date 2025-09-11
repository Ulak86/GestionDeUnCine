package salaCine;

public class SalaDeCine {
	
	private String nombre;
	private int capacidad;
	private String peliculaProyectada;
	private Usuario [][] butacas;
	
	
	public SalaDeCine(String nombre, int capacidad, String peliculaProyectada, Usuario[][] butacas) {
		super();
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.peliculaProyectada = peliculaProyectada;
		this.butacas = butacas;
	}


	
}

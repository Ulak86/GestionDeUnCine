package salaCine;

public class SalaDeCine {

	private String nombre;
	private int capacidad;
	private Pelicula peliculaProyectada;
	private Usuario[][] butacas;

	public SalaDeCine(String nombre, int capacidad, Pelicula peliculaProyectada, int filasSala, int columnasSala) {
		this.nombre = nombre;
		this.capacidad = capacidad;
		this.peliculaProyectada = peliculaProyectada;
		this.butacas = new Usuario[filasSala][columnasSala];
	}

}

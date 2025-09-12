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
	
	public int numeroDeButacasLibres() {
	    int libres = 0;
	    for (int i = 0; i < butacas.length; i++) {
	        for (int j = 0; j < butacas[i].length; j++) {
	            if (butacas[i][j] == null) {
	                libres++;
	            }
	        }
	    }
	    return libres;
	}

	public String getNombre() {
		return nombre;
	}

	public Pelicula getPeliculaProyectada() {
		return peliculaProyectada;
	}

	public Usuario[][] getButacas() {
		return butacas;
	}

	public void setButacas(Usuario[][] butacas) {
		this.butacas = butacas;
	}	
	
	

}

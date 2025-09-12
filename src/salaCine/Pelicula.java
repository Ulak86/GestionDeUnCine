package salaCine;

public class Pelicula {

	private String titulo;
	private int duracion;
	private int clasificacionEdad;
	private double precio;
	private int id;
	private static int contadorIds;

	public Pelicula(String titulo, int duracion, int clasificacionEdad, double precio) {
		this.titulo = titulo;
		this.duracion = duracion;
		this.clasificacionEdad = clasificacionEdad;
		this.precio = precio;
		this.id = ++contadorIds;
	}

	public String getTitulo() {
		return titulo;
	}

	public int getId() {
		return id;
	}
	
}

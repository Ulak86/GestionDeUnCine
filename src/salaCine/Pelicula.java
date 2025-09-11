package salaCine;

public class Pelicula {

	private String titulo;
	private int duracion;
	private int clasificacionEdad;
	private double precio;
	private int id;

	public Pelicula(String titulo, int duracion, int clasificacionEdad, double precio, int id) {
		super();
		this.titulo = titulo;
		this.duracion = duracion;
		this.clasificacionEdad = clasificacionEdad;
		this.precio = precio;
		this.id = id;
	}

}

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


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public int getDuracion() {
		return duracion;
	}


	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}


	public int getClasificacionEdad() {
		return clasificacionEdad;
	}


	public void setClasificacionEdad(int clasificacionEdad) {
		this.clasificacionEdad = clasificacionEdad;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
	
		

}

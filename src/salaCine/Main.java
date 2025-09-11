package salaCine;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		Cine cine1 = new Cine("CineParadiso", 3);

		Pelicula pelicula1 = new Pelicula("El Gran Viaje", 120, 18, 8.50);
		Pelicula pelicula2 = new Pelicula("Aventura Espacial", 95, 7, 7.00);
		Pelicula pelicula3 = new Pelicula("Misterio en la Noche", 110, 0, 9.00);

		SalaDeCine sala1 = new SalaDeCine("Sala 1", 50, pelicula1, 5, 10);
		SalaDeCine sala2 = new SalaDeCine("Sala 2", 40, pelicula2, 4, 10);
		SalaDeCine sala3 = new SalaDeCine("Sala 3", 60, pelicula3, 6, 10);

		SalaDeCine[] salas = { sala1, sala2, sala3 };

		cine1.asignarSalas(salas);

		Usuario[] usuarios = new Usuario[3];

		menuNuevoUsuario(usuarios, sc);

		sc.close();
	}

	public static Usuario[] menuNuevoUsuario (Usuario[] usuarios, Scanner sc) {

		System.out.println(
				"Bienvendio al cine, para poder continuar has de crear un usuario.\nPor favor, introduce tu nombre.");
		String nombre = sc.nextLine();

		System.out.println("Estupendo. Por favor, introduce tu DNI.");
		String dni = sc.nextLine();

		System.out.println("Estupendo. Por favor, introduce tu edad.");
		int edad = sc.nextInt();
		sc.nextLine();

		int entradas;
		do {
			System.out.println("Estupendo. Por favor, introduce el numero de entradas que quieres adquirir.");
			entradas = sc.nextInt();
			sc.nextLine();
			if (entradas < 1) {
				System.out.println("El numero de entradas ha de ser mayor o igual a 1");
			}
		} while (entradas < 1);


		for (int i = 0; i < usuarios.length; i++) {
			if (usuarios[i] == null) {
				usuarios[i] = new Usuario(nombre, dni, edad, entradas);
			}
		}

		return usuarios;
	}
	

}

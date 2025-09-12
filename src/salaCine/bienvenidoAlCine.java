package salaCine;

import java.util.Scanner;

public class bienvenidoAlCine {

	private Cine cine;
	private SalaDeCine[] salas;
	Usuario[] usuarios;

	public static void moloMucho(Scanner sc) {

		System.out.println("Bienvendio al cine.");
		bienvenidoAlCine bienvenidoAlCineMolon = new bienvenidoAlCine();

		SalaDeCine[] salas = bienvenidoAlCineMolon.salas;
		Cine cine1 = bienvenidoAlCineMolon.cine;
		Usuario[] usuarios = bienvenidoAlCineMolon.usuarios;

		boolean salir = false;

		do {
			System.out.println("\nSeleccione el metodo de compra de entradas.\n 1. Asistido \n 2. Manual \n 3. Salir");
			int metodoSelec = sc.nextInt();
			sc.nextLine();

			if (metodoSelec == 1) {
				asistido(sc, salas, cine1, usuarios);
			} else if (metodoSelec == 2) {
				menu(sc, salas);
			} else if (metodoSelec == 3) {
				salir = true;
			} else {
				System.out.println("La opcion seleccionado no existe");
			}

		} while (!salir);

		System.out.println("¡Vuelva pronto a nuestro cine!");

	}

	public static void menu(Scanner sc, SalaDeCine[] salas) {
		boolean salir = false;
		do {
			System.out.println(
					"\nSeleccione la opcion del menu.\n 1. Listar películas y disponibilidad \n 2. Comprar entradas \n 3. Mostrar ocupación por sala\n 4. Salir");
			int metodoSelec = sc.nextInt();
			sc.nextLine();
			if (metodoSelec == 1) {
				listarPeliculasYDisponibilidad(salas);
			} else if (metodoSelec == 2) {
				comprarEntradas();
			} else if (metodoSelec == 3) {
				mostrarOcupacionPorSala();
			} else if (metodoSelec == 4) {
				salir = true;
			} else {
				System.out.println("La opcion seleccionado no existe");
			}
		} while (!salir);

		System.out.println("Volviendo al menu principal.");
	}

	private static void listarPeliculasYDisponibilidad(SalaDeCine[] salas) {
		int entradasDisponibles = 0;

		Usuario[][] butacas = null;
		
		for (SalaDeCine salaDeCine : salas) {
			System.out.println(salaDeCine.getNombre());
			System.out.println(salaDeCine.getPeliculaProyectada().getTitulo());			
			butacas = salaDeCine.getButacas();
			for (int i = 0; i < butacas.length; i++) {
				for (int j = 0; j < butacas[i].length; j++) {
					if (butacas[i][j] == null) {
						entradasDisponibles++;
					}
				}
			}
			System.out.println("Numero de butacas disponibles: " + entradasDisponibles);
		}
	}

	private static void comprarEntradas() {
		// TODO Auto-generated method stub

	}

	private static void mostrarOcupacionPorSala() {
		// TODO Auto-generated method stub

	}

	public bienvenidoAlCine() {
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

		this.cine = cine1;
		this.salas = salas;
		this.usuarios = usuarios;

	}

	public static void asistido(Scanner sc, SalaDeCine[] salas, Cine cine1, Usuario[] usuarios) {

		cine1.asignarSalas(salas);

		menuNuevoUsuario(usuarios, sc);

		comprarEntrada(cine1, usuarios, sc);

	}

	public static Usuario[] menuNuevoUsuario(Usuario[] usuarios, Scanner sc) {

		System.out.println("Para poder continuar has de crear un usuario. Por favor, introduce tu nombre.");
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

	public static Cine comprarEntrada(Cine cine, Usuario[] usuarios, Scanner sc) {

		int numeroDeEntradas = 0;

		Usuario usuario = null;

		for (int i = usuarios.length - 1; i >= 0; i--) {
			if (usuarios[i] != null) {
				numeroDeEntradas = usuarios[i].getEntradas();
				usuario = usuarios[i];
				break;
			}
		}

		System.out.println(numeroDeEntradas);

		SalaDeCine[] salas = cine.getSalas();

		boolean entradasDisponiblesSuficientes = false;

		for (SalaDeCine salaDeCine : salas) {
			int libres = salaDeCine.numeroDeButacasLibres();
			if (numeroDeEntradas <= libres) {
				entradasDisponiblesSuficientes = true;
				break;
			}
		}

		if (!entradasDisponiblesSuficientes) {
			System.out.println("No hay salas con " + numeroDeEntradas + " entradas disponibles.");
		} else {
			System.out.println("\nLas siguientes salas tienen " + numeroDeEntradas + " o mas entradas disponibles");

			for (SalaDeCine salaDeCine : salas) {
				int libres = salaDeCine.numeroDeButacasLibres();
				if (numeroDeEntradas <= libres) {
					System.out.println("\nSala: " + salaDeCine.getNombre());
					System.out.println("Pelicula" + salaDeCine.getPeliculaProyectada().getTitulo());
					System.out.println("ID: " + salaDeCine.getPeliculaProyectada().getId());
				}
			}

			System.out.println("\nIntroduce el ID de la pelicula que quieres ver");

			int idPeliculaSeleccionada = sc.nextInt();
			sc.nextLine();

			SalaDeCine salaSeleccionada = null;

			for (SalaDeCine salaDeCine : salas) {
				if (salaDeCine.getPeliculaProyectada().getId() == idPeliculaSeleccionada) {
					salaSeleccionada = salaDeCine;
					break;
				}
			}

			Usuario[][] butacas = salaSeleccionada.getButacas();

			int filaLibre = -1;
			int columnaLibre = -1;
			boolean encontrado = false;

			for (int i = 0; i < butacas.length && !encontrado; i++) {
				for (int j = 0; j < butacas[i].length && !encontrado; j++) {
					if (butacas[i][j] == null) {
						filaLibre = i;
						columnaLibre = j;
						encontrado = true;
					}
				}
			}

			int entradasAsignadas = 0;

			System.out.println("Se ha realizado la siguiente compra:\nNumero de entradas: " + numeroDeEntradas
					+ "\nSala: " + salaSeleccionada.getNombre() + "\nPelicula: "
					+ salaSeleccionada.getPeliculaProyectada().getTitulo());

			System.out.println("Butaca(s) asignadas: ");

			for (int i = filaLibre; i < butacas.length; i++) {
				for (int j = (i == filaLibre ? columnaLibre : 0); j < butacas[i].length; j++) {
					if (butacas[i][j] == null) {
						butacas[i][j] = usuario;
						entradasAsignadas++;
						System.out.println("[" + (i + 1) + ", " + (j + 1) + "]");
						if (entradasAsignadas == numeroDeEntradas) {
							System.out.println("\n");
							break;
						}
					}
				}
				if (entradasAsignadas == numeroDeEntradas) {
					break;
				}
			}

		}

		return cine;
	}

}

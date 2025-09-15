package salaCine;

import java.util.Scanner;

class BienvenidoAlCine {

	private Cine cine;
	private SalaDeCine[] salas;
	Usuario[] usuarios;

	
	/**
	 * Método que da la bienvenida al usuario al cine y gestiona la interacción.
	 *
	 * Este método debe ser llamado desde el programa principal, y es necesario
	 * pasarle un objeto {@link Scanner} para gestionar la entrada del usuario.
	 *
	 * @param sc Objeto Scanner que se utilizará para leer la entrada del usuario.
	 */
	
	static void moloMucho(Scanner sc) {

		System.out.println("Bienvendio al cine.");
		BienvenidoAlCine bienvenidoAlCineMolon = new BienvenidoAlCine();

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
				menu(sc, salas, usuarios, cine1);
			} else if (metodoSelec == 3) {
				salir = true;
			} else {
				System.out.println("La opcion seleccionado no existe");
			}

		} while (!salir);

		System.out.println("¡Vuelva pronto a nuestro cine!");

	}

	private static void menu(Scanner sc, SalaDeCine[] salas, Usuario[] usuarios, Cine cine1) {
		
		
		menuNuevoUsuario(usuarios, sc);
				
		boolean salir = false;
		
		do {
			System.out.println(
					"\nSeleccione la opcion del menu.\n 1. Listar películas y disponibilidad \n 2. Comprar entradas \n 3. Mostrar ocupación por sala\n 4. Salir");
			int metodoSelec = sc.nextInt();
			sc.nextLine();
			if (metodoSelec == 1) {
				listarPeliculasYDisponibilidad(salas);
			} else if (metodoSelec == 2) {
				comprarEntrada(cine1, usuarios, sc);
			} else if (metodoSelec == 3) {
				mostrarOcupacionPorSala(salas);
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

	private static void mostrarOcupacionPorSala(SalaDeCine[] salas) {
	    for (SalaDeCine sala : salas) {
	        System.out.println("===============================================");
	        System.out.println("Sala: " + sala.getNombre());

	        Pelicula pelicula = sala.getPeliculaProyectada();
	        if (pelicula != null) {
	            System.out.println("Película proyectada: " + pelicula.getTitulo());
	        } else {
	            System.out.println("Película proyectada: (ninguna)");
	        }

	        Usuario[][] butacas = sala.getButacas();
	        System.out.println("Detalle de butacas:");

	        // Detalles de cada butaca
	        for (int i = 0; i < butacas.length; i++) {
	            for (int j = 0; j < butacas[i].length; j++) {
	                Usuario usuario = butacas[i][j];
	                System.out.print("Butaca [" + i + "][" + j + "]: ");
	                if (usuario == null) {
	                    System.out.println("Libre");
	                } else {
	                    System.out.println("Ocupada por " + usuario.getNombre() + " (DNI: " + usuario.getDni() + ")");
	                }
	            }
	        }

	        // Representación gráfica
	        System.out.println("\nMapa gráfico de la sala:");

	        // Encabezado con índices de columnas
	        System.out.print("    ");
	        for (int j = 0; j < butacas[0].length; j++) {
	            System.out.printf(" %2d ", j);
	        }
	        System.out.println();

	        // Separador
	        System.out.print("    ");
	        for (int j = 0; j < butacas[0].length; j++) {
	            System.out.print("----");
	        }
	        System.out.println();

	        // Filas con índices y estado
	        for (int i = 0; i < butacas.length; i++) {
	            System.out.printf(" %2d|", i);
	            for (int j = 0; j < butacas[i].length; j++) {
	                char simbolo = (butacas[i][j] == null) ? 'L' : 'X';
	                System.out.printf(" %2c ", simbolo);
	            }
	            System.out.println();
	        }

	        System.out.println("\n(L = Libre, X = Ocupada)");
	        System.out.println("===============================================\n");
	    }
	}



	public BienvenidoAlCine() {
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

	private static void asistido(Scanner sc, SalaDeCine[] salas, Cine cine1, Usuario[] usuarios) {

		cine1.asignarSalas(salas);

		menuNuevoUsuario(usuarios, sc);

		comprarEntrada(cine1, usuarios, sc);

	}

	private static Usuario[] menuNuevoUsuario(Usuario[] usuarios, Scanner sc) {

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

	private static Cine comprarEntrada(Cine cine, Usuario[] usuarios, Scanner sc) {

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

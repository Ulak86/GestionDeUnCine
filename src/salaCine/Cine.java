package salaCine;

import java.util.Iterator;

public class Cine {

	String nombre;
	SalaDeCine[] salas;

	public Cine(String nombre, int numSalas) {
		
		this.nombre = nombre;
		this.salas = new SalaDeCine[numSalas];
		
	}

	public void asignarSalas (SalaDeCine[] salas) {
		for (int i = 0; i < this.salas.length; i++) {
			this.salas[i] = salas[i];
		}
	}

	public SalaDeCine[] getSalas() {
		return salas;
	}
	
	
	
}

package org.iesalandalus.programacion.torreajedrez;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre torre;
	
	public static void main(String[] args) {
		boolean centinela = false;


		
	}
	
	private static void mostrarTorre() {
		System.out.println(torre.toString());
		
	}
	
	private static void mostrarMenu() {
		System.out.println("Menú");
		System.out.println("----------------------------");
		System.out.println("1- Crear torre por defecto");
		System.out.println("2- Crear torre de un color");
		System.out.println("3- Crear torre con columna inicial");
		System.out.println("4- Mover la torre");
		System.out.println("5- Salir");
	}
	
	private static int elegirOpcion() {
		int eleccion = 0;
		do {
		System.out.println("Por favor, elija una opción del Menú");
		eleccion=Entrada.entero();
		} while (eleccion<1 || eleccion>5);
		return eleccion;
	}
	
	private static Color elegirColor() {
		int eleccionColor = 0;
		do {
		System.out.println("Por favor, elija un color para su torre:");
		System.out.println("1- Negra");
		System.out.println("2- Blanca");
		eleccionColor=Entrada.entero();
		} while (eleccionColor!=1 && eleccionColor!=2);
		if (eleccionColor==1) {
			return Color.NEGRO;
		}
		else {
			return Color.BLANCO;
		}
	}
	
	private static char elegirColumnaInicial() {
		char eleccionColumna = 'x';
		do {
		System.out.println("Por favor, seleccione la columna inicial 'a' o 'h'");
		eleccionColumna=Character.toLowerCase(Entrada.caracter());
//		eleccionColumna=Entrada.caracter();
//		eleccionColumna=Character.toLowerCase(eleccionColumna);
		} while (eleccionColumna!='a' && eleccionColumna!='h');
		return eleccionColumna;
	}
	
	private static void mostrarMenuDirecciones() {
		System.out.println("Menú Dirección");
		System.out.println("----------------------------------");
		System.out.println("1. Arriba");
		System.out.println("2. Abajo");
		System.out.println("3. Izquierda");
		System.out.println("4. Derecha");
		System.out.println("5. Enroque Corto");
		System.out.println("6. Enroque Largo");
	}
	
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int eleccionDireccion = 0;
		do {
			System.out.println("Por favor, la dirección hacia la que se desea mover del Menú Dirección");
			eleccionDireccion=Entrada.entero();
		} while (eleccionDireccion<1 || eleccionDireccion>6);
		switch (eleccionDireccion) {
		case 1:
			direccion = Direccion.ARRIBA;
			break;
		case 2:
			direccion = Direccion.ABAJO;
			break;
		case 3:
			direccion = Direccion.IZQUIERDA;
			break;
		case 4:
			direccion = Direccion.DERECHA;
			break;
		case 5:
			direccion = Direccion.ENROQUE_CORTO;
			break;
		case 6:
			direccion = Direccion.ENROQUE_LARGO;
			break;
		}
		return direccion;
	}
	
	private static void crearTorreDefecto() {
		torre = new Torre();
	}
	
	private static void crearTorreColor() {
		torre = new Torre(elegirColor());
	}
	
	private static void crearTorreColorColumna() {
		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

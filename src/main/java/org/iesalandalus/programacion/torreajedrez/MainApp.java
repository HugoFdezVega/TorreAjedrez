package org.iesalandalus.programacion.torreajedrez;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.utilidades.Entrada;

public class MainApp {

	private static Torre torre;

//	Método Main
	public static void main(String[] args) {
		boolean centinela = false;
		int apuntador = 0;

		do {
			mostrarMenu();
			apuntador = elegirOpcion();
			ejecutarOpcion(apuntador);
			if (apuntador == 5) {
				centinela = true;
			}
			if (apuntador != 5) {
				mostrarTorre();
			}
		} while (centinela == false);
	}

//	Método mostrarTorre - Nos dice dónde se encuentra la torre en cada momento
	private static void mostrarTorre() {
		System.out.println("------------------");
		System.out.println("Tu torre está en " + torre.toString());
		System.out.println("------------------");
	}

//	Método mostrarMenú - Nos muestra el Menú de opciones general
	private static void mostrarMenu() {
		System.out.println("Menú");
		System.out.println("----------------------------");
		System.out.println("1- Crear torre por defecto");
		System.out.println("2- Crear torre de un color");
		System.out.println("3- Crear torre con columna inicial");
		System.out.println("4- Mover la torre");
		System.out.println("5- Salir");
	}

//	Método elegirOpcion - Nos pide una opción para el Menú principal
	private static int elegirOpcion() {
		int eleccionMenu = 0;
		do {
			System.out.println("Por favor, elija una opción del Menú");
			eleccionMenu = Entrada.entero();
			try {
				if (eleccionMenu == 4 && torre == null) {
					throw new NullPointerException("ERROR: Cree una torre para poder moverla.");
				}
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		} while (eleccionMenu < 1 || eleccionMenu > 5 || (eleccionMenu == 4 && torre == null));
		return eleccionMenu;
	}

//	Método elegirColor - Nos pide una opción para elegir el color de la torre
	private static Color elegirColor() {
		int eleccionColor = 0;
		do {
			System.out.println("Por favor, elija un color para su torre:");
			System.out.println("1- Negra");
			System.out.println("2- Blanca");
			eleccionColor = Entrada.entero();
		} while (eleccionColor != 1 && eleccionColor != 2);
		if (eleccionColor == 1) {
			return Color.NEGRO;
		} else {
			return Color.BLANCO;
		}
	}

//	Método elegirColumnaInicial - Nos pide una opción para posicionar la torre en su columna inicial
	private static char elegirColumnaInicial() {
		char eleccionColumna = 'x';
		do {
			System.out.println("Por favor, seleccione la columna inicial 'a' o 'h'");
			eleccionColumna = Character.toLowerCase(Entrada.caracter());
		} while (eleccionColumna != 'a' && eleccionColumna != 'h');
		return eleccionColumna;
	}

//	Méotodo mostrarMenuDirecciones - Nos muestra el Menú Dirección
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

//	Método elegirDireccion - Nos pide una dirección para mover la torre
	private static Direccion elegirDireccion() {
		Direccion direccion = null;
		int eleccionDireccion = 0;
		do {
			System.out.println("Por favor, seleccione del Menú Dirección hacia dónde se desea mover:");
			eleccionDireccion = Entrada.entero();
		} while (eleccionDireccion < 1 || eleccionDireccion > 6);
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

//	Método crearTorreDefecto - Nos crear una torre con los valores por defecto
	private static void crearTorreDefecto() {
		torre = new Torre();
	}

//	Método crearTorreColor - Nos crea una torre con el color que elijamos
	private static void crearTorreColor() {
		torre = new Torre(elegirColor());
	}

//	Método crearTorreColorColumna - Nos crea una torre con el color y en la columna inicial que elijamos
	private static void crearTorreColorColumna() {
		torre = new Torre(elegirColor(), elegirColumnaInicial());
	}

//	Método mover - Nos pide el número de casillas que queremos mover la torre y la mueve o la enroca
	private static void mover() {
		int pasos = 0;
		Direccion direccion = null;
		mostrarMenuDirecciones();
		direccion = elegirDireccion();
		if (direccion == Direccion.ENROQUE_CORTO || direccion == Direccion.ENROQUE_LARGO) {
			try {
				torre.enrocar(direccion);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		} else {
			System.out.println("¿Cuántas casillas te gustaría moverte?");
			pasos = Entrada.entero();
			try {
				torre.mover(direccion, pasos);
			} catch (OperationNotSupportedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

//	Método ejecutarOpcion - Ejecuta las opciones elegidas en el Menú principal
	private static void ejecutarOpcion(int apuntador) {
		int opcionElegida = apuntador;
		switch (opcionElegida) {
		case 1:
			crearTorreDefecto();
			break;
		case 2:
			crearTorreColor();
			break;
		case 3:
			try {
				crearTorreColorColumna();
			} catch (IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
			break;
		case 4:
			mover();
			break;
		case 5:
			System.out.println("¡Que tengas un buen día!");
			break;
		}
	}

	
	
	
	
	
	
	
	
	
	
}

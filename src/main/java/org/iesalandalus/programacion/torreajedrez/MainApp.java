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
		System.out.println("Por favor, elija una opción de entre las anteriores");
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
		eleccionColumna=Entrada.caracter();
		} while (eleccionColumna!='a' && eleccionColumna!='h');
		return eleccionColumna;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

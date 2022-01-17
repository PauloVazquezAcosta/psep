package exercicio_1;

import java.util.Scanner;

public class Exercicio_1 extends Thread {
	// Creamos as variables que terá a secuencia
	private static int a, b, x, y, z;
	// Creamos a operación, cada fío terá a súa para o switch de run()
	private int operacion;

	// Introducimos a operación a facer cando creemos o fío de cada exercicio
	public Exercicio_1(int operacion) {
		this.operacion = operacion;
	}

	public static void main(String[] args) {
		// Creamos o teclado
		Scanner teclado = new Scanner(System.in);
		
		// Pedimos os valores
		System.out.print("Introduce o valor de y: ");
		y = teclado.nextInt();
		System.out.print("Introduce o valor de a: ");
		a = teclado.nextInt();
		System.out.print("Introduce o valor de b: ");
		b = teclado.nextInt();

		// Creamos os dous fíos do exercicio 1 do PDF
		Exercicio_1 f1 = new Exercicio_1(1);
		Exercicio_1 f2 = new Exercicio_1(2);

		// Iniciamos os fíos
		f1.start();
		f2.start();

		// Esta parte fai que o main espere a que ambos fíos acaben e absorbe a excepción co try catch
		try {
			f1.join();
			f2.join();
		} catch (InterruptedException e) {
		}
		;

		/*
		 * while (h1.isAlive() || h2.isAlive()) { }
		 */

		System.out.println("O programa terminou");
	}

	public void run() { // o método start() executa directamente o run()

		switch (operacion) {
		case 1: // Operacións do fío 1
			x = y + 1;
			System.out.println("x vale: " + x);
			y = x + 2;
			System.out.println("y vale: " + y);
			break;
		case 2: // Operacións do fío 2
			z = a + b;
			System.out.println("z vale: " + z);
			break;
		}
	}

}

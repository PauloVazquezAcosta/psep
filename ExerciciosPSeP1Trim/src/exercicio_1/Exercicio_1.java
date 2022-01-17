package exercicio_1;

import java.util.Scanner;

public class Exercicio_1 extends Thread {
	// Creamos as variables que ter� a secuencia
	private static int a, b, x, y, z;
	// Creamos a operaci�n, cada f�o ter� a s�a para o switch de run()
	private int operacion;

	// Introducimos a operaci�n a facer cando creemos o f�o de cada exercicio
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

		// Creamos os dous f�os do exercicio 1 do PDF
		Exercicio_1 f1 = new Exercicio_1(1);
		Exercicio_1 f2 = new Exercicio_1(2);

		// Iniciamos os f�os
		f1.start();
		f2.start();

		// Esta parte fai que o main espere a que ambos f�os acaben e absorbe a excepci�n co try catch
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

	public void run() { // o m�todo start() executa directamente o run()

		switch (operacion) {
		case 1: // Operaci�ns do f�o 1
			x = y + 1;
			System.out.println("x vale: " + x);
			y = x + 2;
			System.out.println("y vale: " + y);
			break;
		case 2: // Operaci�ns do f�o 2
			z = a + b;
			System.out.println("z vale: " + z);
			break;
		}
	}

}

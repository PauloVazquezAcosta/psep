package exercicio_2;

import java.util.Scanner;

public class Exercicio_2 extends Thread {
	// Creamos as variables que terá a secuencia
	private static int cuad, x, m1, a, m2, b, z, y, c;
	// Creamos a operación, cada fío terá a súa para o switch de run()
	private int operacion;

	// Introducimos a operación a facer cando creemos o fío de cada exercicio
	public Exercicio_2(int operacion) {
		this.operacion = operacion;
	}

	public static void main(String[] args) {
		// Creamos o teclado
		Scanner teclado = new Scanner(System.in);

		// Pedimos os valores
		System.out.print("Introduce o valor de x: ");
		x = teclado.nextInt();
		System.out.print("Introduce o valor de a: ");
		a = teclado.nextInt();
		System.out.print("Introduce o valor de b: ");
		b = teclado.nextInt();
		System.out.print("Introduce o valor de c: ");
		c = teclado.nextInt();

		// Creamos os dous fíos do exercicio 2 do PDF
		Exercicio_2 f1 = new Exercicio_2(1);
		Exercicio_2 f2 = new Exercicio_2(2);

		// Iniciamos os fíos
		f1.start();
		f2.start();

		// Esta parte fai que o main espere a que ambos fíos acaben e absorbe a
		// excepción co try catch
		try {
			f1.join();
			f2.join();
		} catch (InterruptedException e) {
		}
		;

		// Cando acaben os fíos, continuamos as operacións no main xa que son
		// secuenciais
		z = m1 + m2;
		System.out.println("z vale: " + z);
		y = z + c;
		System.out.println("y vale: " + y);

		System.out.println("O programa terminou");
	}

	public void run() { // o método start() executa directamente o run()

		switch (operacion) {
		case 1: // Operacións do fío 1
			cuad = x * x;
			System.out.println("cuad vale: " + cuad);
			m1 = a * cuad;
			System.out.println("m1 vale: " + m1);
			break;
		case 2: // Operacións do fío 2
			m2 = b * x;
			System.out.println("m2 vale: " + m2);
			break;
		}
	}

}

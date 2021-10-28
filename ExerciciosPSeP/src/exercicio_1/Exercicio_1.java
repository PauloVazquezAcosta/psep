package exercicio_1;

import java.util.Scanner;

public class Exercicio_1 extends Thread {
	private static int a, b, x, y, z;
	private int operacion;

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
		Exercicio_1 h1 = new Exercicio_1(1);
		Exercicio_1 h2 = new Exercicio_1(2);
		
		h1.start();
		h2.start();
		
		try{ h1.join(); h2.join(); }catch(InterruptedException e){};
		

		/*
		 * while (h1.isAlive() || h2.isAlive()) {
		 * }
		 */


		System.out.println("El programa ha terminado");
	}

	public void run() {

		switch (operacion) {
		case 1:
			x = y + 1;
			System.out.println("x vale: " + x);
			y = x + 2;
			System.out.println("y vale: " + y);
			break;
		case 2:
			z = a + b;
			System.out.println("z vale: " + z);
			break;
		}
	}

}

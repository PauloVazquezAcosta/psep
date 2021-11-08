/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_6;

import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class Exercicio_6Runnable implements Runnable {

    private static double a, x, b, y, z, c, d;

    private int operacion;

    public Exercicio_6Runnable(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce o valor de x: ");
        x = teclado.nextDouble();
        System.out.print("Introduce o valor de y: ");
        y = teclado.nextDouble();
        System.out.print("Introduce o valor de z: ");
        z = teclado.nextDouble();

        Exercicio_6Runnable o1 = new Exercicio_6Runnable(1);
        Exercicio_6Runnable o2 = new Exercicio_6Runnable(2);

        Thread f1 = new Thread(o1);
        Thread f2 = new Thread(o2);

        f1.start();
        f2.start();

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }

        d = a + c;
        System.out.println("d vale: " + d);

    }

    @Override
    public void run() {
        switch (operacion) {
            case 1:
                a = 2 * x;
                System.out.println("a vale: " + a);
                break;
            case 2:
                b = y - z;
                System.out.println("b vale: " + b);
                c = b / 3;
                System.out.println("c vale: " + c);
                break;
        }
    }
}

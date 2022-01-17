/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_4;

import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class Exercicio_4Thread extends Thread {

    private static double a, b, u, c, v, w, d, x;

    private int operacion;

    public Exercicio_4Thread(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce o valor de a: ");
        a = teclado.nextDouble();
        System.out.print("Introduce o valor de b: ");
        b = teclado.nextDouble();
        System.out.print("Introduce o valor de c: ");
        c = teclado.nextDouble();
        System.out.print("Introduce o valor de d: ");
        d = teclado.nextDouble();

        u = a * b;
        System.out.println("u vale: " + u);

        Exercicio_4Thread f1 = new Exercicio_4Thread(1);
        Exercicio_4Thread f2 = new Exercicio_4Thread(2);

        f1.start();
        f2.start();

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {

        };

    }

    public void run() {
        switch (operacion) {
            case 1:
                v = u + c;
                System.out.println("v vale: " + v);
                break;
            case 2:
                w = u - d;
                System.out.println("w vale: " + w);
                break;
        }
    }
}

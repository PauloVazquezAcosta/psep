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
public class Exercicio_4Runnable implements Runnable {

    private static double a, b, u, c, v, w, d, x;

    private int operacion;

    public Exercicio_4Runnable(int operacion) {
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

        Exercicio_4Runnable p2 = new Exercicio_4Runnable(1);
        Exercicio_4Runnable p3 = new Exercicio_4Runnable(2);

        Thread fp2 = new Thread(p2);
        Thread fp3 = new Thread(p3);

        fp2.start();
        fp3.start();

        try {
            fp2.join();
            fp3.join();
        } catch (InterruptedException e) {
        }
        ;

        x = v / w;
        System.out.println("x vale: " + x);
    }

    @Override
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

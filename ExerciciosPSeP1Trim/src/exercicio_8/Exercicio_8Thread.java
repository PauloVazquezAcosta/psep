/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_8;

import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class Exercicio_8Thread extends Thread {

    public static long a, x, y, b, c, d, e, f;

    public int operacion;

    public Exercicio_8Thread(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce o valor de x: ");
        x = teclado.nextLong();
        System.out.print("Introduce o valor de y: ");
        y = teclado.nextLong();

        Exercicio_8Thread f1 = new Exercicio_8Thread(1);
        Exercicio_8Thread f2 = new Exercicio_8Thread(2);

        f1.start();
        f2.start();
        c = x * y;
        System.out.println("c vale: " + c);

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }

        Exercicio_8Thread f4 = new Exercicio_8Thread(4);

        f4.start();
        e = a * b * c;
        System.out.println("e vale: " + e);

        try {
            f4.join();
        } catch (InterruptedException e) {
        }

        f = d - e;
        System.out.println("f vale: " + f);

        System.out.println("O programa terminou");
    }

    public void run() {
        switch (operacion) {
            case 1:
                a = x + y;
                System.out.println("a vale: " + a);
                break;
            case 2:
                b = x - y;
                System.out.println("b vale: " + b);
                break;
            case 4:
                d = a + b + c;
                System.out.println("d vale: " + d);
                break;
        }
    }

}

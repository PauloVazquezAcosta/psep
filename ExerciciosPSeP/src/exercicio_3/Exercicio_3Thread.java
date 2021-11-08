/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_3;

import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class Exercicio_3Thread extends Thread {

    // Creamos as variables que terá a secuencia
    private static int a, b, c, d, e, g;
    private static double f, w; // Facemos f como double porque se calculará o seu seuno
    // Creamos a operación, cada fío terá a súa para o switch de run()
    private int operacion;

    public Exercicio_3Thread(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {
        // Creamos o teclado
        Scanner teclado = new Scanner(System.in);

        // Pedimos os valores
        System.out.print("Introduce o valor de b: ");
        b = teclado.nextInt();
        System.out.print("Introduce o valor de c: ");
        c = teclado.nextInt();
        System.out.print("Introduce o valor de e: ");
        e = teclado.nextInt();
        System.out.print("Introduce o valor de w: ");
        w = teclado.nextInt();

        Exercicio_3Thread f1 = new Exercicio_3Thread(1);
        Exercicio_3Thread f2 = new Exercicio_3Thread(2);

        f1.start();
        f2.start();

        f = c + e;
        System.out.println("f fale: " + f);

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }
        ;

        System.out.println("función (" + a + ", " + d + ", " + f + ")");
        f = Math.sin(w);
        System.out.println("f fale: " + f);
        System.out.println("O programa terminou");
    }

    public void run() {
        switch (operacion) {
            case 1:
                a = b + c;
                System.out.println("a vale: " + a);
                break;
            case 2:
                d = b + e;
                System.out.println("d vale: " + d);
                break;
        }
    }

}

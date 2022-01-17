/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_10;

import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class Exercicio_10Runnable implements Runnable {

    public static double a, x, m, b, n, c, y, z;
    public int operacion;

    public Exercicio_10Runnable(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce o valor de x: ");
        x = teclado.nextDouble();
        System.out.print("Introduce o valor de b: ");
        b = teclado.nextDouble();
        System.out.print("Introduce o valor de c: ");
        c = teclado.nextDouble();

        Exercicio_10Runnable o1 = new Exercicio_10Runnable(1);
        Exercicio_10Runnable o2 = new Exercicio_10Runnable(2);

        Thread f1 = new Thread(o1);
        Thread f2 = new Thread(o2);

        f1.start();
        f2.start();

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }
        
        Exercicio_10Runnable o3 = new Exercicio_10Runnable(3);
        Exercicio_10Runnable o4 = new Exercicio_10Runnable(4);
        
        Thread f3 = new Thread(o3);
        Thread f4 = new Thread(o4);
        
        f3.start();
        f4.start();
        
        try{
            f3.join();
            f4.join();
        }catch(InterruptedException e){}
        
        System.out.println("O programa terminou");

    }

    @Override
    public void run() {
        switch (operacion) {
            case 1:
                a = x * x;
                System.out.println("a vale: " + a);
                m = a * b;
                System.out.println("m vale: " + m);
                break;
            case 2:
                n = c * x;
                System.out.println("n vale: " + n);
                break;
            case 3:
                y = m + n;
                System.out.println("y vale: " + y);
                break;
            case 4:
                z = m - n;
                System.out.println("z vale: " + z);
                break;
        }

    }
}

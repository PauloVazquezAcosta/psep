/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_9;

import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class Exercicio_9Thread extends Thread {

    public static int a, x, y, b, c, d, e;
    public int operacion;

    public Exercicio_9Thread(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Introduce o valor de x: ");
        x = teclado.nextInt();
        System.out.print("Introduce o valor de y: ");
        y = teclado.nextInt();

        Exercicio_9Thread f1 = new Exercicio_9Thread(1);
        Exercicio_9Thread f2 = new Exercicio_9Thread(2);

        f1.start();
        f2.start();

        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }

        e = b + d;
        System.out.println("e vale: " + e);
        
        System.out.println("O programa terminou");

    }
    
    @Override
    public void run(){
        switch(operacion){
            case 1:
                a = x + y;
                System.out.println("a vale: " + a);
                b = a + 3;
                System.out.println("b vale: " + b);
                break;
            case 2:
                c = x * y;
                System.out.println("c vale: " + c);
                d = c + 8;
                System.out.println("d vale: " + d);
                break;
        }
    }
}

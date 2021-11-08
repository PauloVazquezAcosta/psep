package exercicio_3;

import java.util.Scanner;

public class Exercicio_3Runnable extends Thread implements Runnable {

    // Creamos as variables que terá a secuencia
    private static int a, b, c, d, e, g;
    private static double f, w; // Facemos f como double porque se calculará o seu seuno
    // Creamos a operación, cada fío terá a súa para o switch de run()
    private int operacion;

    // Introducimos a operación a facer cando creemos o fío de cada exercicio
    public Exercicio_3Runnable(int operacion) {
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

        // Creo un obxecto de cada fío, o terceiro irá no main
        Exercicio_3Runnable o1 = new Exercicio_3Runnable(1);
        Exercicio_3Runnable o2 = new Exercicio_3Runnable(2);

        // Asocio cada operación ao fío
        Thread f1 = new Thread(o1);
        Thread f2 = new Thread(o2);

        // Iniciamos os fíos
        f1.start();
        f2.start();
        // Iniciamos o fío do main, poñemos as operacións correspondentes despois dos fíos
        f = c + e;
        System.out.println("f fale: " + f);

        // Esta parte fai que o main espere a que ambos fíos acaben e absorbe a
        // excepción co try catch
        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }
        ;
        
        System.out.println("función (" + a +", " + d + ", " + f + ")");
        f = Math.sin(w);
        System.out.println("f fale: " + f);
        System.out.println("O programa terminou");

    }
    
    @Override
    public void run() {
        switch (operacion) {
            case 1: // Operacións do fío 1
                a = b + c;
                System.out.println("a vale: " + a);
                break;
            case 2: // Operaci�ns do f�o 2
                d = b + e;
                System.out.println("d vale: " + d);
                break;
        }

    }

}

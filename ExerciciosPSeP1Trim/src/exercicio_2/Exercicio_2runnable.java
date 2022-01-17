package exercicio_2;

import java.util.Scanner;

public class Exercicio_2Runnable implements Runnable {
    // Creamos as variables que ter� a secuencia

    private static int cuad, x, m1, a, m2, b, z, y, c;
    // Creamos a operaci�n, cada f�o ter� a s�a para o switch de run()
    private int operacion;

    // Introducimos a operaci�n a facer cando creemos o f�o de cada exercicio
    public Exercicio_2Runnable(int operacion) {
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

        // Creo un obxecto de cada f�o
        Exercicio_2Runnable o1 = new Exercicio_2Runnable(1);
        Exercicio_2Runnable o2 = new Exercicio_2Runnable(2);

        // Asocio cada operaci�n ao f�o
        Thread f1 = new Thread(o1);
        Thread f2 = new Thread(o2);

        // Iniciamos os f�os
        f1.start();
        f2.start();

        // Esta parte fai que o main espere a que ambos f�os acaben e absorbe a
        // excepci�n co try catch
        try {
            f1.join();
            f2.join();
        } catch (InterruptedException e) {
        }
        ;

        // Cando acaben os f�os, continuamos as operaci�ns no main xa que son
        // secuenciais
        z = m1 + m2;
        System.out.println("z vale: " + z);
        y = z + c;
        System.out.println("y vale: " + y);

        System.out.println("O programa terminou");

    }

    @Override
    public void run() {
        switch (operacion) {
            case 1: // Operaci�ns do f�o 1
                cuad = x * x;
                System.out.println("cuad vale: " + cuad);
                m1 = a * cuad;
                System.out.println("m1 vale: " + m1);
                break;
            case 2: // Operaci�ns do f�o 2
                m2 = b * x;
                System.out.println("m2 vale: " + m2);
                break;
        }

    }
}

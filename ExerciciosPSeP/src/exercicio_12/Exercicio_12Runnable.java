/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_12;

/**
 *
 * @author Paulo
 */
public class Exercicio_12Runnable implements Runnable {

    public static int[] numeros = new int[100];
    public static long suma = 0;
    public static double produto = 1;
    public static int valorMaximo = Integer.MIN_VALUE;
    public static int valorMinimo = Integer.MAX_VALUE;
    public int operacion;

    public Exercicio_12Runnable(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {
        // Enchemos o array con 100 números aleatorios
        EncherArray(numeros);

        // Mostramos os números xerados
        MostrarArray(numeros);
        System.out.println();

        Exercicio_12Runnable o1 = new Exercicio_12Runnable(1);
        Exercicio_12Runnable o2 = new Exercicio_12Runnable(2);
        Exercicio_12Runnable o3 = new Exercicio_12Runnable(3);
        Exercicio_12Runnable o4 = new Exercicio_12Runnable(4);

        Thread f1 = new Thread(o1);
        Thread f2 = new Thread(o2);
        Thread f3 = new Thread(o3);
        Thread f4 = new Thread(o4);

        f1.start();
        f2.start();
        f3.start();
        f4.start();

        try {
            f1.join();
            f2.join();
            f3.join();
            f4.join();
        } catch (InterruptedException e) {
        }

    }

    public static int[] EncherArray(int[] array) {
        for (int i = 0; i < 100; i++) {
            array[i] = NumeroAleatorio();
        }

        return array;
    }

    private static int NumeroAleatorio() {
        int numeroAleatorio = (int) (Math.random() * 100 + 1);

        return numeroAleatorio;
    }

    public static void MostrarArray(int[] array) {
        for (int i = 0; i < 100; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static long CalcularSuma(int[] array) {
        for (int i = 0; i < 100; i++) {
            suma += array[i];
        }

        return suma;
    }

    public static double CalcularProduto(int[] array) {
        for (int i = 0; i < 100; i++) {
            produto = produto * array[i];
        }

        return produto;
    }

    public static int CalcularValorMaximo(int[] array) {
        for (int i = 0; i < 100; i++) {
            if (array[i] > valorMaximo) {
                valorMaximo = array[i];
            }
        }

        return valorMaximo;
    }

    public static int CalcularValorMinimo(int[] array) {
        for (int i = 0; i < 100; i++) {
            if (array[i] < valorMinimo) {
                valorMinimo = array[i];
            }
        }

        return valorMinimo;
    }

    @Override
    public void run() {
        switch (operacion) {
            case 1:
                suma = CalcularSuma(numeros);
                System.out.println("A suma dos números é " + suma);
                break;
            case 2:
                produto = CalcularProduto(numeros);
                System.out.println("O produto dos números é " + produto);
                break;
            case 3:
                valorMaximo = CalcularValorMaximo(numeros);
                System.out.println("O valor máximo dos números é " + valorMaximo);
                break;
            case 4:
                valorMinimo = CalcularValorMinimo(numeros);
                System.out.println("O valor mínimo dos números é " + valorMinimo);
                break;
        }
    }
}

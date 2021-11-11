/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_11;

/**
 *
 * @author Paulo
 */
public class Exercicio_11Thread extends Thread {

    public static int operando_1, operando_2;

    public int operacion;

    public Exercicio_11Thread(int operacion) {
        this.operacion = operacion;
    }

    public static void main(String[] args) {
        // Xeramos dous número aleatorio entre 1 e 100
        operando_1 = NumeroAleatorio();
        operando_2 = NumeroAleatorio();

        Exercicio_11Thread f1 = new Exercicio_11Thread(1);
        Exercicio_11Thread f2 = new Exercicio_11Thread(2);
        Exercicio_11Thread f3 = new Exercicio_11Thread(3);
        Exercicio_11Thread f4 = new Exercicio_11Thread(4);

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

    public static int NumeroAleatorio() {
        int numeroAleatorio = (int) (Math.random() * 100 + 1);

        return numeroAleatorio;
    }

    @Override
    public void run() {
        switch (operacion) {
            case 1:
                int suma = operando_1 + operando_2;
                System.out.println(operando_1 + " + " + operando_2 + " = " + suma);
                break;
            case 2:
                int resta = operando_1 - operando_2;
                System.out.println(operando_1 + " - " + operando_2 + " = " + resta);
                break;
            case 3:
                int produto = operando_1 * operando_2;
                System.out.println(operando_1 + " * " + operando_2 + " = " + produto);
                break;
            case 4:
                float division = (float) operando_1 / (float) operando_2;
                System.out.println(operando_1 + " / " + operando_2 + " = " + division);
                break;
        }
    }
}

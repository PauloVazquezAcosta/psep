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
public class Exercicio_10Runnable implements Runnable{
    public static long a, x, m, b, n, c, y, z;
    public int operacion;
    
    public Exercicio_10Runnable(int operacion){
        this.operacion = operacion;
    }
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        System.out.print("Introduce o valor de x: ");
        x = teclado.nextLong();
        System.out.print("Introduce o valor de b: ");
        b = teclado.nextLong();
        System.out.print("Introduce o valor de c: ");
        c = teclado.nextLong();
        
    }
    @Override
    public void run(){
        
    }
}

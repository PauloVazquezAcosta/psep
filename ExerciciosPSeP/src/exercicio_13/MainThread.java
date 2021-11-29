/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_13;

/**
 *
 * @author Paulo
 */
public class MainThread extends Thread{
    public int operacion;
    
    public MainThread(int operacion){
        this.operacion = operacion;
    }
    
    public static void main(String[] args) {
        int[] tempoPaco = new int[]{8,1,6,10};
        int[] tempoManolo = new int[]{3,2,3,1};
        
        Cliente Paco = new Cliente(tempoPaco);
        Cliente Manolo = new Cliente(tempoManolo);
        
        
               
    }
    
}

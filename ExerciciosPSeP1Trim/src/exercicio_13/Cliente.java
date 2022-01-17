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
public class Cliente {
    private int tempos[];
    
    public Cliente(int[] tempos){
        this.tempos = tempos;
    }

    public int[] getTempos() {
        return tempos;
    }

    public void setTempos(int[] tempos) {
        this.tempos = tempos;
    }
    
    
    }

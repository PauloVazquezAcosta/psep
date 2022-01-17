/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author Paulo
 */
public class Cliente {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        //Lemos o primeiro parámetro, onde debe ir o enderezo IP do servidor
        InetAddress enderezo = null;

        try {
            enderezo = InetAddress.getByName("localhost");
            System.out.println(enderezo);

        } catch (UnknownHostException ex) {
            System.out.println("Host non atopado: " + ex);
            System.exit(-1);
        }

        //Porto que usamos para conectar ao servidor
        int porto = 1234;
        Socket socket = null;
        DataInputStream receptor = null;
        DataOutputStream emisor = null;

        try {
            //Creamos o socket
            socket = new Socket(enderezo, porto);
            //Extraemos os streams de entrada e saída
            receptor = new DataInputStream(socket.getInputStream());
            emisor = new DataOutputStream(socket.getOutputStream());
            System.out.print("Introduce o primeiro número: ");
            int numero1 = teclado.nextInt();
            //Escribímolo
            emisor.writeInt(numero1);

            if (numero1 > 0) {

                System.out.print("Introduce o segundo número: ");
                int numero2 = teclado.nextInt();
                emisor.writeInt(numero2);
                if (numero2 > 0) {
                    //Lemos o resultado final
                    long resultado = receptor.readLong();
                    //Mostramos en pantalla
                    System.out.println("O máximo común divisor de " + numero1 + " e " + numero2 + " é: " + resultado);
                }
            }
            //Pechamos as conexións deste socket
            receptor.close();
            emisor.close();

        } catch (IOException ex) {
        }

        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException ioe) {
            System.err.println("Error ao pechar o socket: " + ioe);
        }

    }

}

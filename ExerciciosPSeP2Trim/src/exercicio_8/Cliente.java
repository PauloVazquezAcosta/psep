/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_8;

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

        String frase;

        try {
            //Creamos o socket
            socket = new Socket(enderezo, porto);
            //Extraemos os streams de entrada e saída
            receptor = new DataInputStream(socket.getInputStream());
            emisor = new DataOutputStream(socket.getOutputStream());

            do {
                System.out.print("Introduza a frase a enviar: ");
                frase = teclado.nextLine();
                emisor.writeUTF(frase);

                frase = receptor.readUTF();
                System.out.println(frase);

            } while (!frase.equalsIgnoreCase("Adiosssssssssss"));

            receptor.close();
            emisor.close();
            socket.close();

        } catch (IOException ioe) {
        }

    }

}

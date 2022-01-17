/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_6;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.InputMismatchException;
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
            Boolean resultado = false;
            int numero;

            do {
                try {
                    System.out.print("Introduce un número: ");
                    numero = teclado.nextInt();
                } catch (InputMismatchException ime) {
                    numero = Integer.MIN_VALUE;
                    teclado.next();
                }
            } while (numero == Integer.MIN_VALUE);

            emisor.writeInt(numero);

            if (numero != 0) {
                String resposta;
                resultado = receptor.readBoolean();
                resposta = receptor.readUTF();
                System.out.println(resposta);

                while (resultado == false && numero != 0) {

                    System.out.print("Introduce un número: ");
                    numero = teclado.nextInt();
                    //Escribímolo
                    emisor.writeInt(numero);

                    resultado = receptor.readBoolean();
                    resposta = receptor.readUTF();
                    System.out.println(resposta);

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

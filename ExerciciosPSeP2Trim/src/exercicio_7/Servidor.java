/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_7;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Paulo
 */
public class Servidor {

    public static void main(String[] args) {
        try {
            // Indicamos o enderezo IP local
            System.out.println("Servidor iniciado");
            System.out.println("LocalHost = " + InetAddress.getLocalHost().toString());
        } catch (UnknownHostException ex) {
            System.err.println("Non podo saber o enderezo IP local: " + ex);
        }

        //abrimos un socket de servidor no porto 1234
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(1234);
        } catch (IOException ex) {
            System.err.println("Erro ao abrir o socket do servidor: " + ex);
            System.exit(-1);
        }
        int operacion, operando1, operando2;
        double resultado;

        while (true) {

            try {
                //Esperamos a que alguien se conecte a nuestro socket
                Socket socket = serverSocket.accept();
                //Extraemos los streams de entrada y salida
                DataInputStream receptor = new DataInputStream(socket.getInputStream());
                DataOutputStream emisor = new DataOutputStream(socket.getOutputStream());
                //podemos extraer información del socket
                //Nº de puerto remoto
                int porto = socket.getPort();
                //dirección Internet remota
                InetAddress enderezo = socket.getInetAddress();

                operacion = receptor.readInt();
                operando1 = receptor.readInt();
                operando2 = receptor.readInt();

                switch (operacion) {
                    case 1:
                        resultado = operando1 + operando2;
                        emisor.writeUTF("O resultado é: " + resultado);
                        break;
                    case 2:
                        resultado = operando1 - operando2;
                        emisor.writeUTF("O resultado é: " + resultado);
                        break;
                    case 3:
                        resultado = operando1 * operando2;
                        emisor.writeUTF("O resultado é: " + resultado);
                        break;
                    case 4:
                        resultado = operando1 / operando2;
                        emisor.writeUTF("O resultado é: " + resultado);
                        break;
                }

                receptor.close();
                emisor.close();
                socket.close();

            } catch (IOException ex) {
            }

        }

    }

}

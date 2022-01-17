/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exercicio_4;

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
            System.err.println("Error ao abrir o socket do servidor: " + ex);
            System.exit(-1);
        }

        int entradaOrixinal;
        long saida;
        while (serverSocket != null) {

            try {
                Socket socket = serverSocket.accept();
                //Extraemos os streams de entrada e saída
                DataInputStream receptor = new DataInputStream(socket.getInputStream());
                DataOutputStream emisor = new DataOutputStream(socket.getOutputStream());
                //podemos extraer información do socket
                //Nº de porto remoto
                int porto = socket.getPort();
                //enderezo Internet remota
                InetAddress enderezo = socket.getInetAddress();
                //Lemos datos da petición
                entradaOrixinal = receptor.readInt();
                int entrada = entradaOrixinal;
                // Se a entrada é menor a 0 calculamos o factorial, senón seguimos
                if (entrada <= 0) {
                    System.out.println("Cliente = " + enderezo + ":" + porto + "\tEntrada = "
                            + entradaOrixinal + "\tSaída = Non existe o factorial de " + entrada);
                    System.out.println("Servidor pechado");
                    serverSocket.close();
                    serverSocket = null;

                } else {
                    //Calculamos resultado
                    saida = 1;
                    while (entrada > 0) {
                        saida = saida * entrada;
                        entrada--;
                    }
                    //Escribimos el resultado
                    emisor.writeLong(saida);
                    //Registramos en salida estandar
                    System.out.println("Cliente = " + enderezo + ":" + porto + "\tEntrada = "
                            + entradaOrixinal + "\tSaída = " + saida);
                }

                //Cerramos los streams
                receptor.close();
                emisor.close();
                socket.close();

            } catch (IOException ex) {
                System.err.println("Producíuse a excepción en: " + ex);
            }
        }

    }

}

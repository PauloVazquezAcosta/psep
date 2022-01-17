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

        int numeroOculto = (int) (Math.random() * 1000) + 1;
        
        System.out.println(numeroOculto);

        int entrada;
        Boolean resultado;
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
                System.out.println(porto);
                //dirección Internet remota
                InetAddress enderezo = socket.getInetAddress();

                //Leemos datos de la petición
                entrada = receptor.readInt();
                while (entrada != numeroOculto) {
                    if (entrada == 0) {
                        System.out.println("Saíndo do programa");
                    } else if (numeroOculto > entrada) {
                        resultado = false;
                        emisor.writeBoolean(resultado);
                        emisor.writeUTF("O número oculto é maior");
                    } else {
                        resultado = false;
                        emisor.writeBoolean(resultado);
                        emisor.writeUTF("O número oculto é menor");
                    }

                    entrada = receptor.readInt();
                }

                if (entrada == numeroOculto) {
                    resultado = true;
                    emisor.writeBoolean(resultado); 
                    emisor.writeUTF("Acertaches");
                }

                receptor.close();
                emisor.close();
                socket.close();

            } catch (IOException ex) {
            }

        }

    }

}

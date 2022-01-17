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
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

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

        int numero1, numero2;
        long resultado;

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

                numero1 = receptor.readInt();

                if (numero1 > 0) {
                    numero2 = receptor.readInt();
                    if (numero2 > 0) {
                        resultado = maximoComunDivisor(numero1, numero2);

                        //Escribimos el resultado
                        emisor.writeLong(resultado);
                        //Registramos en salida estandar
                        System.out.println("Cliente = " + enderezo + ":" + porto + "\tNúmero 1 = "
                                + numero1 + "\tNúmero 2 = " + numero2 + "\tMCD = " + resultado);
                    } else {
                        System.out.println("Cliente = " + enderezo + ":" + porto + "\tNúmero 1 = "
                                + numero1 + "\tNúmero 2 = " + numero2 + "\tSaída = Non se pode calcular MCD de  " + numero2);
                        System.out.println("Servidor pechado");
                        serverSocket.close();
                        serverSocket = null;

                    }

                } else {
                    System.out.println("Cliente = " + enderezo + ":" + porto + "\tNúmero 1 = "
                            + numero1 + "\tSaída = Non se pode calcular MCD de  " + numero1);
                    System.out.println("Servidor pechado");
                    serverSocket.close();
                    serverSocket = null;

                }
            } catch (IOException ex) {
                Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public static int maximoComunDivisor(int a, int b) {
        int temporal;//Para no perder b
        while (b != 0) {
            temporal = b;
            b = a % b;
            a = temporal;
        }
        return a;
    }

}

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

            int operacion = escollerOperacion(teclado);
            if (operacion > 0 && operacion < 5) {
                int operando1, operando2;
                String resultado;

                do {

                    try {
                        System.out.print("Introduza o primeiro operando: ");
                        operando1 = teclado.nextInt();
                    } catch (InputMismatchException ime) {
                        operando1 = Integer.MIN_VALUE;
                        teclado.next();
                    }
                } while (operando1 == Integer.MIN_VALUE);

                do {
                    try {
                        System.out.print("Introduza o segundo operando: ");
                        operando2 = teclado.nextInt();
                    } catch (InputMismatchException ime) {
                        operando2 = Integer.MIN_VALUE;
                        teclado.next();
                    }
                    if( operacion == 4 && operando2 == 0){
                        System.out.println("Non se pode dividir entre 0");
                    }
                } while (operando2 == Integer.MIN_VALUE || (operacion == 4 && operando2 == 0));

                        emisor.writeInt(operacion);
                        emisor.writeInt(operando1);
                        emisor.writeInt(operando2);
                
                resultado = receptor.readUTF();
                System.out.println(resultado);
                
                
            }

            //Pechamos as conexións deste socket
            receptor.close();
            emisor.close();

        } catch (IOException ioe) {
        }

    }

    public static int escollerOperacion(Scanner teclado) {
        int opcion = 0;

        System.out.println("Escolle unha operación: ");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        System.out.println("5. Saír");
        do {
            System.out.print("\t Operación: ");
            try {
                opcion = teclado.nextInt();

            } catch (InputMismatchException ime) {
                opcion = Integer.MIN_VALUE;
                teclado.next();
            }
        } while (opcion < 1 || opcion > 5);

        return opcion;
    }

}

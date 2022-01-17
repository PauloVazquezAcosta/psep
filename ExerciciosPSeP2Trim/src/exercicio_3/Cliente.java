package exercicio_3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) {
        //Leemos el primer parámetro, donde debe ir la dirección IP del servidor
        InetAddress direcc = null;

        try {
            direcc = InetAddress.getByName("localhost");
            System.out.println(direcc);
        } catch (UnknownHostException uhe) {
            System.out.println("Host no encontrado: " + uhe);
            System.exit(-1);
        }
        //Puerto que hemos usado para el servidor
        int puerto = 1234;
        Socket sckt = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        try {
            System.out.println("Introduce el número del que quieres averiguar el cuadrado: ");
            Scanner sc = new Scanner(System.in);
            int numero = sc.nextInt();
            //creamos el socket
            sckt = new Socket(direcc, puerto);
            //Extraemos los streams de entrada y salida
            dis = new DataInputStream(sckt.getInputStream());
            dos = new DataOutputStream(sckt.getOutputStream());
            //lo escribimos
            dos.writeInt(numero);
            //Leemos el resultado final
            long resultado = dis.readLong();
            //Mostramos en pantalla
            System.out.println("Solicitud = " + numero + "\tResultado = " + resultado);
            //y cerramos los streams y el socket
            dis.close();
            dos.close();
        } catch (IOException e) {
            System.err.println("Se ha producido la excepción: " + e);
        }
        try {
            if (sckt != null) {
                sckt.close();
            }
        } catch (IOException ioe) {
            System.err.println("Error al cerrar el socket: " + ioe);
        }
    }
}

package exercicio_2;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paulo
 */
public class Exercicio_2 {

    static InetAddress dir;
    static String name;
    static String ip;

    public static void main(String[] args) {
        //a

        probaMetodos();

    }

    public static void probaMetodos() {

        //a.2 getLocalHost()
        try {
            dir = InetAddress.getLocalHost();
        } catch (UnknownHostException ex) {
            Logger.getLogger(Exercicio_2.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(dir);

        //a.3 getHostName()
        name = dir.getHostName();
        System.out.print(name + "/");

        //a.4 getHostAddress()
        ip = dir.getHostAddress();

        System.out.println(ip);

    }

}

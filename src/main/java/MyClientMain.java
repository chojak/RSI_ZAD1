import java.rmi.Naming;
import java.rmi.Remote;
import java.util.Scanner;


public class MyClientMain {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            Remote lookup = Naming.lookup("//localhost/ABC");
            MyServerInt myServer = (MyServerInt) lookup;
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.println();
                System.out.print("Podaj równanie: ");
                String request = scanner.nextLine();
                String response = myServer.doMath(request);
                System.out.print("Wynik: " + response);

                if (request == "exit")
                    break;
            }
        }
        catch (Exception ex) {}
    }
}

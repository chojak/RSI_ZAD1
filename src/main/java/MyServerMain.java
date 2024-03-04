import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class MyServerMain {
    public static void main(String[] args) {
        try {
            System.setProperty("java.security.policy", "security.policy");
            if (System.getSecurityManager() == null) {
                System.setSecurityManager(new SecurityManager());
            }

            System.setProperty("java.rmi.server.codebase","file:target/classes");
            System.out.println("Codebase: " + System.getProperty("java.rmi.server.codebase"));
            MyServerImpl obj1 = new MyServerImpl();

            LocateRegistry.createRegistry(1099);
            Naming.rebind("//localhost/ABC", obj1);
            // zamienic localhost na adres ipv4 lokalny

            System.out.println("Serwer oczekuje ...");
        } catch (RemoteException | MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
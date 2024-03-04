import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class MyServerImpl extends UnicastRemoteObject implements MyServerInt {
    int i = 0;
    protected MyServerImpl() throws RemoteException {
        super();
    }
    public String getDescription(String text) throws RemoteException {
        i++;
        System.out.println("MyServerImpl.getDescription: " + text + " " + i);
        return "getDescription: " + text + " " + i;
    }

    @Override
    public String doMath(String input) throws RemoteException {
        String[] splitInput = input.split(" ");
        if (splitInput.length != 3)
            return "Podano zły ciąg znaków";

        Double firstNumber = Double.parseDouble(splitInput[0]);
        Double secondNumber = Double.parseDouble(splitInput[2]);
        String mathSymbol = splitInput[1];

        switch (mathSymbol) {
            case "+":
                return Double.toString(firstNumber + secondNumber);
            case "-":
                return Double.toString(firstNumber - secondNumber);
            case "*":
                return Double.toString(firstNumber * secondNumber);
            case "/":
                if (secondNumber == 0)
                    return "Nie można dzielić przez 0";
                return Double.toString(firstNumber / secondNumber);
            default:
                return "Podano nieobłużony znak";
        }
    }
}
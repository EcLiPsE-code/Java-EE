package models;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client {
    public static final String UNIC_BINDING_NAME = "parseText";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            final Registry registry = LocateRegistry.getRegistry(2099);
            TextParserLogic textParser = (TextParserLogic) registry.lookup(UNIC_BINDING_NAME);
            boolean flag = true;
            while(true){
                System.out.print("Введите сообщение серверу: ");
                String message = scanner.nextLine();
                System.out.println("Ответ сервера: " + textParser.replaceSymbol(message));
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }
}

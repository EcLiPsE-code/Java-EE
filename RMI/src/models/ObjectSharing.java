package models;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ObjectSharing {
    public static final String UNIC_BINDING_NAME = "parseText"; //название удаленного объекта

    public static void main(String[] args) {
        final TextParserServerImpl textParserServer = new TextParserServerImpl(); //Создаем объект для удаленного доступа
        try {
            final Registry registry = LocateRegistry.createRegistry(2099); //создаем реестр, в котором будем регестрировать наш объект для удаленного доступа
                                                                                //port - уникальный номер, по которому другая программа может обратиться к реестру
            Remote stub = UnicastRemoteObject.exportObject(textParserServer, 0); //создание заглушки, которая принимает инф. об удаленном вызове
                                                                                      //распаковывает его, десериализует переданные параметры и вызывает нужный метод
            registry.bind(UNIC_BINDING_NAME, stub);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (AlreadyBoundException e) {
            e.printStackTrace();
        }
    }
}

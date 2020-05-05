package models;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface TextParserLogic extends Remote{
    public String replaceSymbol(String text) throws RemoteException;
}

package models;

import java.rmi.RemoteException;
import java.util.regex.Pattern;

public class TextParserServerImpl implements TextParserLogic {
    @Override
    public String replaceSymbol(String text) throws RemoteException {
        char[] charSymbols = text.toCharArray();
        StringBuilder resultString = new StringBuilder();
        for (char symbol : charSymbols) {
            if (checkDigit(symbol)){
                symbol = '*';
                resultString.append(symbol);
                continue;
            }
            if (checkSpace(symbol)){
                symbol = '_';
                resultString.append(symbol);
                continue;
            }
            if (checkRussianLetters(symbol)){
                symbol = '#';
                resultString.append(symbol);
                continue;
            }
            resultString.append(symbol);
        }
        return resultString.toString();
    }

    private boolean checkDigit(char symbol) {
        try{
            if(Character.isDigit(symbol)){
                return true;
            }else{
                return false;
            }
        }catch (Exception ex){
            return false;
        }
    }

    private boolean checkSpace(char symbol) {
        try{
            if (symbol == ' '){
                return true;
            }else{
                return false;
            }
        }catch (Exception ex){
            return false;
        }
    }

    private boolean checkRussianLetters(char symbol) {
        try{
            String str = String.valueOf(symbol);
            boolean result = str.matches("[\\u0400-\\u04FF]");
            return result;
        }catch (Exception ex){
            return false;
        }
    }
}

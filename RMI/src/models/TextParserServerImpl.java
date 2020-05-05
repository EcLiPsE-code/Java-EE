package models;

import java.rmi.RemoteException;

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
            String stringLetters = "абвгдеёжзиклмнопрстоуфхцчшщъыьэюяАБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
            char[] chArrayLetters = stringLetters.toCharArray();
            for (char letter : chArrayLetters){
                if (symbol == letter){
                    return true;
                }
            }
            return false;
        }catch (Exception ex){
            return false;
        }
    }
}

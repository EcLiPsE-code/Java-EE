package models;

import controllers.TextParser;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.DatagramPacket;

public class Server {
    public static void main(String[] args) {
        DatagramSocket socket = null;
        TextParser textParser = null;
        try{
            socket = new DatagramSocket(3000);
            boolean flag = true;
            while(true){
                byte[] buffer = new byte[10000];
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                textParser = new TextParser();
                String textOnUser = new String(packet.getData());
                String textResult = textParser.replacementSymbol(textOnUser);
                byte[] message = textResult.getBytes();
                DatagramPacket answer = new DatagramPacket(message, message.length, packet.getAddress(), packet.getPort());
                socket.send(answer);
                }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

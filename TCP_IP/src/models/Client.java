package models;

import javax.xml.crypto.Data;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner scanner = new Scanner(System.in);
            boolean flag = true;
            while(flag){
                System.out.print("Введите сообщение серверу: ");
                String str = scanner.nextLine();

                byte[] message = str.getBytes();
                DatagramPacket mesServer = new DatagramPacket(message, message.length, InetAddress.getByName("localhost"), 3000);
                socket.send(mesServer);

                byte[] buffer = new byte[10000];
                DatagramPacket answerServer = new DatagramPacket(buffer, buffer.length);
                socket.receive(answerServer);

                System.out.println("Ответ сервера: " + new String(answerServer.getData()));
            }
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

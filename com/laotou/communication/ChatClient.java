package com.laotou.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

//发送信息线程
class SendClientThreat implements Runnable {
    Socket socket;
    PrintWriter pWriter;
    Scanner scanner;

    public SendClientThreat(Socket socket) {
        super();
        this.socket = socket;
        this.scanner = new Scanner(System.in);
        try {
            pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            String strMsg =socket.getInetAddress().getHostAddress()+":"+ scanner.nextLine();
            pWriter.println(strMsg);
            pWriter.flush();

//			System.out.println(strMsg);
        }

    }
}

//接收信息线程
class ReceiveClientThreat implements Runnable {
    Socket socket;
    BufferedReader bReader;

    public ReceiveClientThreat(Socket socket) {
        super();
        this.socket = socket;
        try {
            bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {

            while (true) {
                String strMsg = bReader.readLine();
                System.out.println(strMsg);
            }

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}


/**
 * 客户端
 * @author Administrator
 *
 */
public class ChatClient {

    private static Socket socket;

    public static void main(String[] args) {
        //服务端的IP
//		String IPAdress="192.168.1.199";
        String IPAdress="127.0.0.1";
        //创建一个客户端socket，指定服务端的IP和端口号
        try {
            socket = new Socket(IPAdress, 30000);
            System.out.println("连接主机成功！ ");

            new Thread(new ReceiveClientThreat(socket)).start();
            new Thread(new SendClientThreat(socket)).start();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


    }

}


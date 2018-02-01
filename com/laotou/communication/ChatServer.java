package com.laotou.communication;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;

//发送信息线程
class SendThreat implements Runnable {
    Socket socket;
    //在这里使用PrintWriter流来向客户端发送信息，也可以用其它流
    PrintWriter pWriter;
    //接收来自主线程的客户端集合
    private ArrayList<Socket> socketList;

    //从键盘输入获取信息
    Scanner scanner = new Scanner(System.in);

    public SendThreat(Socket socket,ArrayList<Socket> socketList) {
        super();
        this.socket = socket;
        this.socketList=socketList;
        try {
            //接收socket的字节输出流，用OutputStreamWriter把字节输出流转化为字符流，再传给PrintWriter
            pWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        while (true) {
            //获取从键盘输入的信息
            String strMsg =socket.getInetAddress().getHostAddress()+":"+ scanner.nextLine();
            if (strMsg == "b") {
                break;
            }

            //把服务器收到的信息转发给各个客户端
            for (Socket clientSock : socketList) {
                PrintWriter pWriter;
                try {
                    //获取socket的输出流，用来向客户端发送信息
                    pWriter = new PrintWriter(clientSock.getOutputStream());
                    //输出信息给客户端
                    pWriter.println(strMsg);
                    //刷新输出流
                    pWriter.flush();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

                // pWriter.close();
            }
//			pWriter.println(strMsg);
//			pWriter.flush();
//			pWriter.close();
            // System.out.println(strMsg);
        }

    }
}

//接收信息线程
class ReceiveThreat implements Runnable {
    Socket socket;
    BufferedReader bReader;
    private ArrayList<Socket> socketList;

    public ReceiveThreat(Socket socket, ArrayList<Socket> socketList) {
        super();
        this.socket = socket;
        this.socketList = socketList;
        try {
            //获取socket的输入流
            bReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true) {

            try {
                String strMsg = bReader.readLine();
                System.out.println(strMsg);

                for (Socket clientSock : socketList) {
                    PrintWriter pWriter = new PrintWriter(clientSock.getOutputStream());
                    pWriter.println(strMsg);
                    pWriter.flush();
                    // pWriter.close();
                }

            } catch (IOException e) {
                // TODO Auto-generated catch block
                ChatServer.socketList.remove(socket);
            }
        }
    }
}


/**
 * 服务端
 * @author Administrator
 *
 */
public class ChatServer {

    //定义一个集合用来存放 监听到的客户端socket
    public static ArrayList<Socket> socketList = new ArrayList<>();

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ServerSocket serverSocket = null;

        try {
            //新建一个服务端ServerSocket，锁定端口号为30000，端口号建议锁定大一点的
            serverSocket = new ServerSocket(30000);
            System.out.println("等待客户端连接...");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        while (true) {
            Socket socket = null;
            while (true) {
                try {
                    //监听客户端的连接
                    socket = serverSocket.accept();
                    //加入集合
                    socketList.add(socket);
                    System.out.println("客户端 " + socket.getInetAddress().getHostAddress() + "连接成功！");

                    // showHello(socket);
                    //为该客户端分别开启一个发送信息线程和接收信息线程
                    new Thread(new SendThreat(socket,socketList)).start();
                    new Thread(new ReceiveThreat(socket, socketList)).start();

                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }

}


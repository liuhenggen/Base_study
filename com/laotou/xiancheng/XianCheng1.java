package com.laotou.xiancheng;

public class XianCheng1 implements  Runnable{
    @Override
    public void run() {
        for (int i = 0 ;i<= 3 ;i++){
            System.out.println(i);
        }
    }
}

class main{

    public static void main(String[] args) {
      XianCheng1 xianCheng1 = new XianCheng1();
      Thread thread = new Thread(xianCheng1,"1号线程");

      thread.start();
        boolean alive = thread.isAlive();
        String string = thread.toString();
        System.err.println(string);
        System.err.println(alive);
        long aa =  thread.getId();
        System.out.println(aa);
    }
}
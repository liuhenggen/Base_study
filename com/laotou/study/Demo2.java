package com.laotou.study;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class Demo2 {

    public static void main(String[] args) {
        BufferedOutputStream bos = null;
        try {
            // 初始化流
            bos = new BufferedOutputStream(new FileOutputStream("D:\\4.txt"));
            // 写
            bos.write("今天内容少,早下课".getBytes());
            bos.flush();// 强制刷新  将输出流中的内容  刷到文件中
            System.out.println("赋值完毕");

            bos.write("\r\n".getBytes());
            bos.flush();

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(bos!=null){
                try {
                    bos.close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

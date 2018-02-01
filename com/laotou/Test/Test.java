package com.laotou.Test;
/*
* 用缓冲流移动一个视频文件，并且删除源文件
* */

import java.io.*;
import java.util.Date;

public class Test {
    public static void main(String[] args) {
        //将e盘中test.avi移到d盘中要重新命名，并删除e盘中的源文件
        //1、先读取文件，然后就读取内容写入到目标文件中；
        File file = new File("e://test.rmvb");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(new File("d://demo.avi"));
            System.out.println("startTime:"+new Date());
            int count = 0 ;
            byte[] bs = new byte[1024*10];
            try {
                while((count = fis.read(bs))!= -1 ){
                    fos.write(bs,0,count);
                    fos.flush();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println("endTime:"+new Date());
        //file.delete();

    }
}

package com.laotou.study;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Demo1 {
    public static void main(String[] args) {
        File file = new File("e:"+File.separator+"test.rmvb");
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(sdf.format(date));
        try {
            bis = new BufferedInputStream(new FileInputStream(file));
            bos = new BufferedOutputStream(new FileOutputStream( new File("d:"+File.separator+"demo1.rmvb")));

            int count = 0;
            byte[] bs = new byte[1024*10];
            try {
                while ((count = bis.read(bs))!= -1){
                    bos.write(bs,0,count);
                   bos.flush();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (bis != null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bos != null){
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(new Date());
    }

}

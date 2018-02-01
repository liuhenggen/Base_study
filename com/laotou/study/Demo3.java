package com.laotou.study;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/*
* 多线程复制视频文件
* */
public class Demo3 {
    // 资源文件位置，文件目标位置
    public static void main(String[] args) {
        File sourceFile = new File("e:" + File.separator + "test.rmvb");
        startThread(30,sourceFile.length(),"e:\\test.rmvb","d:\\aa.rmvb");

    }

    /*
    * @param  threadnum   线程数
    * @param  fileLength  文件长度
    * @param  sourseFilePath   源文件目录
    * @param  targeFilePath    目标文件目录
    * */
    // 开启线程
    public static  void  startThread(int threadnum,long fileLength,String sourseFilePath,String targeFilePath){
        // 每节视频长度
        long modLength = fileLength % threadnum;

        long targetLength = fileLength / threadnum;

        for (int i = 0;i <= targetLength ; i++){

            new copyFile((targetLength*i),(targetLength*(i+1)),sourseFilePath,targeFilePath ).start();
        }

        if (modLength != 0){
            new copyFile((targetLength*threadnum),targetLength*threadnum+modLength+1,sourseFilePath,targeFilePath).start();

        }

    }



    //线程  写线程：指定文件开始位置、目标位置、源文件、目标文件，
    static class copyFile extends  Thread{

       private long begin;
       private long end;
       private RandomAccessFile soursefile;
       private RandomAccessFile targerfile;

        public copyFile(long begin, long end, String sourseFilePath, String targerFilePath) {
            this.begin = begin;
            this.end = end;
            try {
                this.soursefile = new RandomAccessFile(sourseFilePath,"rw");
                this.targerfile = new RandomAccessFile(targerFilePath,"rw");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }

        }


        public void run() {
            try {
                soursefile.seek(begin);
                targerfile.seek(begin);
                int count = 0 ;
                byte[] bs = new byte[1024*10*10];
                while (begin < end && -1 != (count = soursefile.read(bs))){
                    begin += count;
                    targerfile.write(bs,0,count);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    soursefile.close();
                    targerfile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }

}


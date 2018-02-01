package com.laotou.Test;

import java.io.*;

public class FileCope implements Runnable {
    private String sourceFileName = null;   //支援文件路径
    private String targetFileName = null;   //目标文件路径
    private long blockCount;    //总分块数
    private long blockNo;       //当前分块数

    private int maxBufferSize = 1024;

    public FileCope(String sourceFileName, String targetFileName, long blockCount, long blockNo){
        this.sourceFileName = sourceFileName;
        this.targetFileName = targetFileName;
        this.blockCount = blockCount;
        this.blockNo = blockNo;
    }
    public void run() {
        File f = new File(sourceFileName);
        BufferedInputStream bis =null;
       // BufferedOutputStream bos = null;
        //FileInputStream fileIn = null;
        RandomAccessFile fileRead = null;
        try {
            //计算每块的字节数
            long blockLength = f.length()/blockCount;
            //计算起始位置
            long startPosition = blockLength*blockNo;
            byte[] temp = new byte[maxBufferSize*10*10];
            //fileIn = new FileInputStream(f);
            bis = new BufferedInputStream(new FileInputStream(f));
            //设置读取模式为RM（如果当前文件不存在则创建文件）

            //fileRead = new RandomAccessFile(targetFileName,"rw");
            fileRead = new RandomAccessFile(targetFileName,"rw");

            bis.skip(startPosition);

            //fileIn.skip(startPosition);
            fileRead.seek(startPosition);
            //当前读取的字节数
            int curRedLength;
            //累计读取字节数的和
            int totalRedLength=0;
            while((curRedLength = bis.read(temp)) >0 && totalRedLength < blockLength){
                fileRead.write(temp, 0, curRedLength);
                totalRedLength += curRedLength;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                if(fileRead != null){
                    fileRead.close();
                }
                if(bis != null){
                    bis.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}

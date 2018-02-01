package com.laotou.study;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DemoTest {
    public static void main(String[] args){
        String sourceFileName = "E://test.rmvb";
        String targetFileName = "D://copy.rmvb";
        //创建线程池
        ExecutorService ex = Executors.newFixedThreadPool(40);
        long blockCount = 1000;
        long beginTime=System.currentTimeMillis();
        for(int i =0 ; i<blockCount; i ++){
            ex.execute(new FileCope(sourceFileName, targetFileName, blockCount, i));
        }
        ex.shutdown();
        while(true){
            if(ex.isTerminated()){
                long endTime=System.currentTimeMillis();
                System.out.println(endTime- beginTime);
                break;
            }
        }
    }


}

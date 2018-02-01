package com.laotou.Test;

import java.io.*;
import java.util.Scanner;

/*
*  把info1.txt , info2.txt,info3.txt
 * 用String类中的方法截取到 文件名字,不包括拓展名,将名字变成大写,
 * 并且给文件重命名成为 INFO1.txt,INFO2.txt ,INFO3.txt,
 * 并复制到myFiles\txt目录下(须用程序创建txt文件夹)
* */
public class FileTest3 {
    public static void main(String[] args) throws IOException {

        File file = new File("D:/myFiles");
        // 控制台输入内容
        Scanner scanner = new Scanner(System.in);
        String searchStr = scanner.next();

        search(file,searchStr);
        scanner.close();

    }

    private static void  search(File file ,String seachStr){
        // 查看是否是目录，如果是目录就获取目录下所有的文件；
        if (file.isDirectory()){
            // 得到文件数组
           File[] files = file.listFiles();
           for (int i = 0 ; i < files.length ; i++){
               search(files[i],seachStr);
           }
        }else{
            // 如果是文件就如下操作,文件就一行一行读，再判断是否包含输入的内容；
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(file));
                String line = reader.readLine();
                if (line.contains(seachStr)){
                    //如果包含就获取绝对路径和名字
                    System.out.println("路径"+file.getAbsolutePath()+"*********名字是："+file.getName());
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}

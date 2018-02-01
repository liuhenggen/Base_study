package com.laotou.study;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* 1. 使用File类在D盘下创建目录myFiles, 并在myFiles目录下创建三个文件分别为： info1.txt, info2.txt,
 * info3.txt 。
* */
public class FileTest2 {

    public static void main(String[] args)  {
        String path = "D:/myFiles";
        File file = new File(path);
        file.mkdir();
        File[] files = new File[3];
        String[] strings = new String[]{"第一个文件内容，我爱你中国",
                "第二个文件内容，我爱你湖南",
                "第三个文件内容，我爱你湘潭"};
        FileOutputStream fos = null;
        for (int i = 0;i < 3 ;i++){
            files[i] = new File(path,"info"+i+".txt");

            try {
                files[i].createNewFile();
                fos = new FileOutputStream(files[i]);
                fos.write(strings[i].getBytes());
                fos.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (fos != null){

                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

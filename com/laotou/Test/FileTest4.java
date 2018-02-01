package com.laotou.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
   递归思想

* 递归删除myFiles目录，并记录删除的信息，格式为 “INFO1.txt 删除成功(失败) 2015-8-10
 * 10:20:30”.将文件保存到D:\log.txt中，（注意：log.txt文件不要提交）
* */
public class FileTest4 {

    public static void main(String[] args) {
        // separator 隔离符号 因为在win和liu系统分割符是不同，用separator都适应；
        File file = new File("D:"+File.separator+"myFiles");
        BufferedWriter br = null;
        try {
            br = new BufferedWriter(new FileWriter("d:"+File.separator+"log.txt"));
            // 时间戳  规定格式
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            deleteFile(file,br,sdf);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        file.delete();
    }

    private static void deleteFile(File file,BufferedWriter bf,SimpleDateFormat sdf) throws IOException {

        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (int i = 0;i < files.length ; i++){
                    deleteFile(files[i],bf,sdf);
            }
        }else {
            boolean flag = file.delete();
            bf.write(file.getAbsolutePath()+"删除"+(flag?"success":"fail"));
            bf.write(sdf.format(new Date()));
            bf.newLine();
            bf.flush();
        }

    }
}

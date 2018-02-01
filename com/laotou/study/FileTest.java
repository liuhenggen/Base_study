package com.laotou.study;

        import java.io.*;

public class FileTest {
  /*  public static void main(String[] args) throws IOException {

        File file = new File("e:/test");
        file.mkdir();

        if (file.exists() && file.isDirectory()){

            System.out.println("目录存在");

            File file1 = new File("e:/test/test.txt");

            file1.createNewFile();

            String name =  file1.getName();

            String address = file1.getAbsolutePath();

            System.out.println("获取文件名字"+name);

            System.out.println("获取文件的绝对路径"+address);

            String string = "我是中国人";

            int b = 0 ;

            FileInputStream fis = null;

            FileOutputStream fop = null;

             fis = new FileInputStream("e:/test/aa.txt");

             fop = new FileOutputStream(address);

             while ((b = fis.read()) != -1 ){

                 System.out.println("每次读取数："+b);

                 fop.write(b);
             }

             fis.close();

             fop.close();

            System.out.println("写入成功");

        }
    }*/


    public static void main(String[] args) {





    }

    // 将字符串写入到指定文件中
    public void  fileTest1(){

        String str ="张三 0 3000 李四 1 5000 王五 0 4000";

        String[] str1  = new String[10];

        int i = 0 ;
        int j = 0 ;

        while (i <= str.length()){
            str1[j] = str.substring(i,i+9);
            i = i+10;
            j = j+1;
        }

        FileWriter writer = null;

        try {
            writer = new FileWriter("e:/test/aa.txt");
            writer.write(str1[0]);
            writer.write("\r\n");
            writer.write(str1[1]);
            writer.write("\r\n");
            writer.write(str1[2]);
            writer.write("\r\n");
            writer.flush();
            writer.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}

package com.laotou.base;

/*
* 在类内部，对于成员变量，如果在定义的时候没有进行显示的赋值初始化，则Java会保证类的每个成员变量都得到恰当的初始化：

　　1）对于  char、short、byte、int、long、float、double等基本数据类型的变量来说会默认初始化为0（boolean变量默认会被初始化为false）；

　　2）对于引用类型的变量，会默认初始化为null。
*
*
* */

public class Father {
    private  String name;
    public  int age;

    public Father() {
    }

    // 有参构造方法
/*
    public Father(String name, int age) {
        this.name = name;
        this.age = age;
    }
*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public  void run(){
        System.out.println("paobu");
    }

}

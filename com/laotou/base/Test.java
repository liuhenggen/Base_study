package com.laotou.base;

/*
* 在生成对象的过程中，会先初始化对象的成员变量，然后再执行构造器。
* 也就是说类中的变量会在任何方法（包括构造器）调用之前得到初始化，即使变量散步于方法定义之间。
* */

public class Test {
    public static void main(String[] args) {
        new Meal();

    }
}

class Meal{
    public Meal() {
        System.out.println("word");
    }
    Bread bread = new Bread();
}

class  Bread{

    public Bread() {

        System.out.println("hello");
    }
}
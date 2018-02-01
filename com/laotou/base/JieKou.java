package com.laotou.base;
/*
* 什么是接口：
*  接口中可以含有变量和方法。但是要注意，接口中的变量会被隐式地指定为public static final变量
*  （并且只能是public static final变量，用private修饰会报编译错误），
*  而方法会被隐式地指定为public abstract方法且只能是public abstract方法
*  （用其他关键字，比如private、protected、static、 final等修饰会报编译错误），
*  并且接口中所有的方法不能有具体的实现，也就是说，接口中的方法必须都是抽象方法。
*
*
* */
public interface JieKou {

    String  run();
    public String test();
    // 常量
    public  static  final  String  NAME ="LIUHENGGEN ";


}

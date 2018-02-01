package com.laotou.base;
/*
* 什么是抽象类
*抽象类与普通类的区别
* 什么是接口
* 接品与抽象类的区别
*
*
* 什么是抽象方法：
*  抽象方法是一种特殊的方法：它只有声明，而没有具体的实现；
*  抽象方法必须用abstract关键字进行修饰。如果一个类含有抽象方法，则称这个类为抽象类，
*  抽象类必须在类前用abstract关键字修饰。因为抽象类中含有无具体实现的方法，所以不能用抽象类创建对象。
*
*  什么情况用抽象类：对于一个父类，如果它的某个方法在父类中实现出来没有任何意义，
*  必须根据子类的实际需求来进行不同的实现，那么就可以将这个方法声明为abstract方法，
*
*  抽象类和普通类的主要有三点区别：
*  1）抽象方法必须为public或者protected（因为如果为private，则不能被子类继承，子类便无法实现该方法），缺省情况下默认为public。
　　2）抽象类不能用来创建对象；
　　3）如果一个类继承于一个抽象类，则子类必须实现父类的抽象方法。如果子类没有实现父类的抽象方法，则必须将子类也定义为为abstract类
*

* */
public abstract class ChouXiang {

    abstract  void run();


}

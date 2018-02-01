package com.laotou.xiancheng;

public class XianCheng implements  Runnable{

    private int start,end;
    private int sum;

    public XianCheng(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {

        System.out.println(Thread.currentThread().getName()+"开始执行");
        for (int i = start;i <= end; i++){
            sum += i;
        }
        System.out.println(Thread.currentThread().getName()+"执行完成,结果集是："+sum);


    }

    public static void main(String[] args) throws InterruptedException {
        int start = 0;
        int end = 1000;
        int mid = 500;
        XianCheng xianCheng1 = new XianCheng(start, mid);
        XianCheng xianCheng2 = new XianCheng(mid + 1, end);
        Thread thread1 = new Thread(xianCheng1, "一号线程");
        Thread thread2 = new Thread(xianCheng2, "二号线程");
        thread1.start();
        thread2.start();

        //join  等待线程结束，此方法也可以设置线程等待的具体时间；
        thread1.join();
        thread2.join();
        int sum = xianCheng1.sum+xianCheng2.sum;
        System.out.println("求和得到："+sum);
        System.out.println("helloword");
    }

}

package src.java.test.Thread;

import static java.lang.Thread.currentThread;
import static java.lang.Thread.sleep;

public class Threadx implements Runnable {
    int v;
    String name;
    Thread t=new Thread();

    public Threadx(Thread t, String s) {
        name=s;
    }

    @Override
    public void run() {
        System.out.println(currentThread().getName()+" 线程已执行>>");
    }

    public int start(int v){
        System.out.println("Threadx 已执行。。。");
        this.v=v;
        return v;
    }
}

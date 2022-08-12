package src.java.test.Thread;

import org.junit.Test;

import static java.lang.Thread.currentThread;

public class Threaddemo {
    public static void main(String[] args){
        //Threadx t = new Threadx();

        Thread t1=new Thread(new Threadx(null,"th1"),"t1");
        Thread t2=new Thread(new Threadx(null,"th2"),"t2");
        Count count = new Count(100);

        t1.start();
        t2.start();

        Thread t3=new Thread(new Runnable() {
            @Override
            public void run() {
                count.add(90);
            }
        });

        t3.start();

        Thread t4=new Thread(new Threadx(null,"th4"){
            @Override
            public void run() {
                count.dec(150);
            }
        },"t4");

        t4.start();


        Thread t5=new Thread(new Threadx(null,"th5")){
            void deccount(){
                count.dec(50);
            }
        };
        t5.start();

        try {
            t3.join();
            t4.join();
            t5.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Money : "+count.getMoney());





    }
}

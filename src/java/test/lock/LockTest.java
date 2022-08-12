package src.java.test.lock;

import src.java.test.Thread.Count;
import src.java.test.Thread.Threadx;

public class LockTest {
}
/** * Learn Java from https://www.liaoxuefeng.com/
 * *
 * * @author liaoxuefeng */

class Main {

    static final Object LOCK_A = new Object();
//    LOCK_A a;
    static final Object LOCK_B = new Object();

    public static void main(String[] args) {
        Thread t1=new Thread1();
        t1.start();
        new Thread2().start();
    }
    static void sleep1s() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Thread1 extends Thread {
    public void run() {
        System.out.println("Thread-1: try get lock A...");
        synchronized (Main.LOCK_A) {
            System.out.println("Thread-1: lock A got.");
            Main.sleep1s();
            System.out.println("Thread-1: try get lock B...");
            synchronized (Main.LOCK_B) {
                System.out.println("Thread-1: lock B got.");
                Main.sleep1s();
            }
            System.out.println("Thread-1: lock B released.");
        }
        System.out.println("Thread-1: lock A released.");
    }
}

class Thread2 extends Thread {
    public void run() {
        System.out.println("Thread-2: try get lock A...");
        synchronized (Main.LOCK_A) {
            System.out.println("Thread-2: lock A got.");
            Main.sleep1s();
            System.out.println("Thread-2: try get lock B...");
            synchronized (Main.LOCK_B) {
                System.out.println("Thread-2: lock B got.");
                Main.sleep1s();
            }
            System.out.println("Thread-2: lock B released.");
        }
        System.out.println("Thread-2: lock A released.");
    }
}
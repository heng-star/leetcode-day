package src.java.test;

class RunnableDemo implements Runnable {
    private Thread t;
    private String threadName;

    RunnableDemo( String name) {
        threadName = name;
        System.out.println("Creating " +  threadName );
    }

    public void run() {
        System.out.println("Running " +  threadName );
//        try {
            for(int i = 10; i > 0; i--) {
                System.out.println("Thread: " + threadName + ", " + i);
                // 让线程睡眠一会
//                Thread.sleep(1000);
            }
//        }catch (InterruptedException e) {
//            System.out.println("Thread " +  threadName + " interrupted.");
//        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

//    @Override
    public void start () {
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }
}

class Threadextend extends Thread{

    String name;
    public Threadextend(String s) {
        name=s;
        System.out.println("Creating " +  name );
    }
    @Override
    public void run() {
        //run方法线程体
        for(int i = 10; i > 0; i--) {
            System.out.println("Thread: " + name + ", " + i);
            // 让线程睡眠一会
//            try {
//                sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        System.out.println("Thread " +  name + " exiting.");
    }

    public static void main(String[] args) {
        Threadextend thread = new Threadextend("thread-main");
        //thread.start();
        //for (int i = 0; i < 2000; i++) {
            System.out.println(args[0]+"线程的主方法");
        //}
    }

}

public class ThreadTest {
    public static void main(String args[]) {
        Thread t=new Thread(new Runnable() {
            //@Override
            public void run() {
                //自定义内容
            }
        });
        RunnableDemo R1 = new RunnableDemo( "Thread-1");
        R1.start();
        RunnableDemo R2 = new RunnableDemo( "Thread-2");
        R2.start();
        Threadextend R3=new Threadextend("THread-3");
        R3.start();
        String[] arg={"test"};
       // R3.main(arg);
    }
}

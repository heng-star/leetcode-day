package src.java.test.AnnotherClass;

public class AnonymousTest {
    public static void main(String[] args) {

        new Thread() {
            public void run() {
                for (int i = 0; i < 10; i++) {
                    try {
                        sleep(1000);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(i);
                }
            }
        }.start();
    }
    /**
     等价于
     Thread t=new Thread() {
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(i);
            }
        }
     }
     t.start();
     */

}

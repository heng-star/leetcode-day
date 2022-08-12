package src.java.test.clone;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import src.java.test.Thread.Count;

public class CloneTest {
    public static void main(String[] args) throws Exception{

        Count c1 = new Count(10);
        Count c2=c1.clone();
        c2.add(10);
        Count c3=c1.clone();
        c3.add(15);

        System.out.println(c1.getMoney());
        System.out.println(c2.getMoney());
        System.out.println(c3.getMoney());

        Count c4=c1;
        c4.add(11);
        Count c5=c1.myclone();
        c5.add(10);
        System.out.println(c1.getMoney());
        System.out.println(c4.getMoney());
        System.out.println(c5.getMoney());

        Integer a=6;
        Integer b=a;
        b=7;
        System.out.println(a);
        System.out.println(b);

        a=200;
        int c=200;
        int d=c;
        d=250;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
//        System.out.println(a);

    }
}

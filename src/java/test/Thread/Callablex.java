package src.java.test.Thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

//实现Callable接口
public class Callablex implements Callable<String> {

    String name;
    public Callablex(String s) {
        this.name=s;
    }
    public String getName(){
        return this.name;
    }


    //实现Callable 需要定义返回值类型
    @Override
    public String call() throws Exception {
        //重写call方法 有返回值
        System.out.println("执行Call方法");
        return "执行完毕";
    }

    public static void main(String[] args) throws Exception {
        //创建对象
        Callable testCallable1 = new Callablex("name1");
        Callable testCallable2 = new Callablex("name2");
        //创建线程池
        ExecutorService ser = Executors.newFixedThreadPool(10);
        testCallable1.call();
        testCallable1.call();
        testCallable2.call();
        //执行
//        Future<String> submit = ser.submit(testCallable);
        //获取结果
//        String string = submit.get();
//        System.out.println(string);
        //关闭服务
//        ser.shutdown();
    }

}

package src.java.test;

import java.util.ArrayDeque;
import java.util.Queue;

public class ArrayQueueTest {
    public static void main(String[] args){

        ArrayDeque<Integer> q1=new ArrayDeque<>();
        Queue<Integer>      q2=new ArrayDeque<>();

        q1.add(11);
        q1.add(12);
        q1.addFirst(13);
        q1.addFirst(14);
        q1.push(21);
        q1.push(22);
        q1.addLast(23);
        q1.addLast(24);

        q1.pollFirst();
        q1.forEach(System.out::print);
    }
}

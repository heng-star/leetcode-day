package src.java.test.Thread;

import src.java.test.lock.MyClone;

public class Count implements Cloneable, MyClone {
    int money;
    public Count(){
    }
    public Count(final int money) {
        this.money = money;
    }
    public boolean add(int v){
        money=money+v;
        return true;
    }
    public boolean dec(int v){
        if(money -v <=0){
            System.out.println("error : dec.....");
            return false;
        }
        money=money-v;
        return true;
    }
    public int getMoney() {
        return this.money;
    }
    @Override
    public Count clone() throws CloneNotSupportedException {
        Count a=(Count) super.clone();
        return a;

    }

//    @Override
    public Count myclone () throws CloneNotSupportedException {
        Count a=(Count) super.clone();
        return a;
    }




}

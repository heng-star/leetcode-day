package src.java.test.clone;

public class Money {
    int money;
    public Money(){
        money=0;
    }
    public boolean add(int v){
        if(v>0){
            money=money+v;
            return true;
        }
        return false;
    }
}

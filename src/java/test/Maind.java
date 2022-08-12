package src.java.test;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Maind {

    static ArrayList<Integer> l;
    static int n;
    static int[][] d=new int[][]{{-1,0},{0,-1},{0,1},{1,0}};

    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别



        String str=in.nextLine();

        str.replace('[','{');
        str.replace(']','}');

//        ObjectOutputStream obos=new ObjectOutputStream();

//        int[][] a1=new int[][]();

        n=Integer.parseInt(in.nextLine());
        int a[][] =new int[n][n];
        int b[][] =new int[n][n];//visit

        for(int i=0;i<n;i++){
            String[] t=in.nextLine().split(", ");
            for(int j=0;j<t.length;j++){
                a[i][j]=Integer.parseInt(t[j]);// t[j]-"0";
                b[i][j]=Integer.parseInt(t[j]);// t[j]-"0";
            }
        }

        int v=Integer.parseInt(in.nextLine());
        l=new ArrayList<>();

        dfs(v,v,a);


        Collections.sort(l);
        System.out.print("[");
        int k=0;
        for(int e:l){
            k++;
            if(k!=l.size()){
                System.out.print(e+", ");
            }else {
                System.out.println(e+"]");
            }
        }
    }

    private static void dfs(int vi,int vj, int[][] a) {
        if(vi<n && 0<=vi && vj<n && 0<=vj){
            if(!l.contains(vi)){l.add(vi);};
            if(!l.contains(vj)){l.add(vj);};
            a[vi][vj]=0;
            for(int i=0;i<n;i++){
                if(a[vi][i]==1){
                    dfs(vi,i,a);
                }
                if(a[i][vi]==1){
                    dfs(i,vi,a);
                }
                if(a[vj][i]==1){
                    dfs(vj,i,a);
                }
                if(a[i][vj]==1){
                    dfs(i,vj,a);
                }
            }
        }else{
            return;
        }
    }
}
/*
4
1, 1, 0, 1
0, 1, 0, 0
0, 1, 1, 0
1, 0, 0, 1
2
*/

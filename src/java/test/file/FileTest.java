package src.java.test.file;

import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FileTest {

    @Test
    public void printtest(){
        System.out.println("hello");
    }

    @Test
    public void pathtest(){
        Path p1 = Paths.get(".", "project", "study"); // 构造一个Path对象
        System.out.println(p1);
        Path p2 = p1.toAbsolutePath(); // 转换为绝对路径
        System.out.println(p2);
        Path p3 = p2.normalize(); // 转换为规范路径
        System.out.println(p3);
        File f = p3.toFile(); // 转换为File对象
        System.out.println(f);
        for (Path p : Paths.get("..").toAbsolutePath()) { // 可以直接遍历Path
            System.out.println("  " + p);
        }
    }

    @Test
    public void fileouttest() throws Exception{
        OutputStream output = new FileOutputStream("out/readme.txt");
        output.write("file \n".getBytes());
        output.write("Hello".getBytes("UTF-8")); // Hello
        output.flush();
//        output.close();
    }

    List<Integer> l=new ArrayList<>();

    @Test
    public void readtest() throws Exception{
        Reader read=new FileReader("out/readme.txt");
        char t;
        int a;
        StringBuilder sb=new StringBuilder();
        while ((a=read.read())!=-1){
            t=(char) a;
            sb.append(t);
        }
        read.close();
        System.out.println(sb);
    }

    @Test
    public void printwritetest() throws Exception{

        InputStream ip=new FileInputStream("out/readme.txt");

        File f1=new File("src/java/test/file/demo1.txt");
        File f2=new File("src/java/test/file/demo2.txt");

//        if(f1.is)

        if(!f1.isFile()){f1.createNewFile();}
        if(!f2.isFile()){f2.createNewFile();}
//        f.
        OutputStream op=new FileOutputStream(f1);
        InputStream is=new FileInputStream(f1);
//        is.read()!=null

//        InputStream is= new StringReader("hello socket");

        Socket s=new Socket("127.0.0.1",8001);

//        Stream

        //

        BufferedReader br=new BufferedReader(new InputStreamReader(is));
        //
//        BufferedWriter bw=new BufferedWriter(new );

        OutputStream outputStream=new FileOutputStream(String.valueOf(s.getOutputStream()));

        s.getInputStream();

//        Buffer bf=new Buffer();

        PrintStream ps=new PrintStream(f1);
        ps.write("file \n".getBytes());
        ps.print("this is pw\n");
        ps.flush();

        PrintWriter pw=new PrintWriter(f2);
        pw.println("file \nhello");
        pw.flush();

    }

    @Test
    public void readFile() throws IOException {

        File f= new File("src/readme.txt");
        if(!f.isFile()){f.createNewFile();}

        try (Reader reader = new FileReader(f)) {
//            if(reader)
            char[] buffer = new char[1000];
            int n;
            int i=0;
            while ((n = reader.read(buffer)) != -1) {
                System.out.println("read " + n + " chars."+buffer[i++]);
            }
            for(int j=0;j<i;j++){
                System.out.print(buffer[j]);
            }

        }
    }





}

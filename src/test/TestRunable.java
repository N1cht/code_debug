package test;

import com.sun.org.apache.bcel.internal.generic.FieldOrMethod;

import java.util.concurrent.TimeoutException;

/**
 * Created by Sou1AtLab on 2018/3/15 0015.
 */
public class TestRunable implements Runnable {

    private String name;

    public TestRunable(String name) {
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.print(this.name);
        }
    }

    public static void main(String[] args) {
        TestRunable tr1 = new TestRunable("a");
        TestRunable2 tr2 = new TestRunable2(100);
        Thread th1 = new Thread(tr1);
        Thread th2 = new Thread(tr2);
        th1.start();
        th2.start();
    }
}

class TestRunable2 implements Runnable{

    private int num;

    public TestRunable2(int num) {
        this.num = num;
    }

    public void run(){
        for (int i = 0; i < this.num; i++) {
            System.out.print(i);
        }
    }
}

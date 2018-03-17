package test;

/**
 * Created by Sou1AtLab on 2018/3/15 0015.
 */
public class TestThread extends Thread{

    private String name;

    TestThread(String name){
        this.name = name;
    }

    public void run(){
        for (int i = 0; i < 100; i++) {
            System.out.print(this.name);
        }
    }

    public static void main(String[] args) {

        TestThread th1 = new TestThread("a");
        TestThread2 th2 = new TestThread2(100);
        th1.start();
        th2.start();
    }
}

class TestThread2 extends Thread{

    private int num;

    TestThread2(int n){
        this.num = n;
    }

    public void run(){
        for (int i = 0; i < num; i++) {
            System.out.print(i);
        }
    }
}

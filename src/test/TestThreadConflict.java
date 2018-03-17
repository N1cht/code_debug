package test;

import java.security.spec.ECField;

/**
 * Created by Sou1AtLab on 2018/3/15 0015.
 */
public class TestThreadConflict implements Runnable {

    private volatile int num;

    public TestThreadConflict(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void increase(){
        this.num += 1;
    }

    public void increaseByNum(int n){
        this.num += n;
    }

    public void run(){
        try {

            for (int i = 0; i < 100; i++) {

                Thread.sleep(50);
                    this.increase();
                System.out.println(this.getNum());
            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {

        }
    }

    public static void main(String[] args) {
        TestThreadConflict ttc = new TestThreadConflict(0);
        Thread th1 = new Thread(ttc);
        Thread th2 = new Thread(ttc);

        th1.start();
        th2.start();

    }
}

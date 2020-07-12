package ThreadCommunicate;

import java.util.Date;
import java.util.concurrent.CyclicBarrier;

public class ThreeThreadStartDemo {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
    public void threadStart(){
        String name = Thread.currentThread().getName();
        System.out.println("线程"+name+"准备完毕");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程"+name+"执行完毕"+new Date().getTime());
    }

    public static void main(String[] args) {
        ThreeThreadStartDemo tdmo = new ThreeThreadStartDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                tdmo.threadStart();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                tdmo.threadStart();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                tdmo.threadStart();
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

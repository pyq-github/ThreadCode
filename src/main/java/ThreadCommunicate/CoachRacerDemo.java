package ThreadCommunicate;
//CountDownLatch方法

import java.util.concurrent.CountDownLatch;

public class CoachRacerDemo {
    private CountDownLatch countDownLatch = new CountDownLatch(3);
    //运动员方法
    public void racer(){
        String name = Thread.currentThread().getName();
        System.out.println("运动员"+name+"正在准备");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("运动员"+name+"准备完毕！");
        countDownLatch.countDown();
    }
    public void coach(){
        String name = Thread.currentThread().getName();
        System.out.println("教练"+name+"正在等待运动员到齐");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("教练"+name+"开始训练！");
    }

    public static void main(String[] args) {
        CoachRacerDemo cdmo = new CoachRacerDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                cdmo.racer();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                cdmo.racer();
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                cdmo.racer();
            }
        });
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                cdmo.coach();
            }
        });
        t4.start();
        t3.start();
        t2.start();
        t1.start();
    }
}

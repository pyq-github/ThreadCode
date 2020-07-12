package ThreadCommunicate;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEventDemoCondition {
    private int i = 0;
    private Lock lock = new ReentrantLock(false);
    private Condition condition = lock.newCondition();
    public void odd() {
        while (i < 10) {
            try {
                lock.lock();
                if (i % 2 == 0) {
                    System.out.println("偶数：" + i);
                    i++;
                    condition.signal();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }
    public void jdd(){
        while (i < 10) {
            try {
                lock.lock();
                if (i % 2 == 1) {
                    System.out.println("奇数：" + i);
                    i++;
                    condition.signal();
                } else {
                    try {
                        condition.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        OddEventDemoCondition  odes = new OddEventDemoCondition ();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                odes.odd();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                odes.jdd();
            }
        });
        t1.start();
        t2.start();
    }
}


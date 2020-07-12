package DeadLock;

import java.util.ArrayList;

public class DeadLockExample {
    public static Object obj1 = new Object();
    public static Object obj2 = new Object();
    public static void main(String[] args) {
        DeadLock d1= new DeadLock();
        DeadLock1 d2 = new DeadLock1();
        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        t1.start();
        t2.start();

    }
}

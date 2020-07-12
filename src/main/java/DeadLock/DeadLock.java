package DeadLock;

import ThreadSecurity.Ticket;

public class DeadLock implements Runnable{
    @Override
    public void run() {
        synchronized (DeadLockExample.obj1) {
            System.out.println(DeadLockExample.obj1.toString());
            System.out.println(Thread.currentThread().getName() + "线程已经获取obj1，正在请求obj2");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockExample.obj2) {
                System.out.println(DeadLockExample.obj2.toString() + "===" + DeadLockExample.obj1.toString());
                System.out.println(Thread.currentThread().getName() + "线程已经获取obj1,obj2");
            }
        }
    }
}

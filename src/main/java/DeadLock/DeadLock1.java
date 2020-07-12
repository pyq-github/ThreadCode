package DeadLock;

public class DeadLock1 implements Runnable{
    @Override
    public void run() {
        synchronized (DeadLockExample.obj2){
            System.out.println(DeadLockExample.obj1.toString());
            System.out.println(Thread.currentThread().getName()+"线程已经获取obj2,正在请求obj1");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (DeadLockExample.obj1){
                System.out.println(DeadLockExample.obj1.toString()+"==="+DeadLockExample.obj2.toString());
                System.out.println(Thread.currentThread().getName()+"线程已经获取obj2,obj1");
            }
        }

    }
}

package ThreadSecurity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Ticket implements Runnable {
    private int tickit = 100;
    private Object object = new Object();
    private Lock lock = new ReentrantLock(true);
    @Override
    public void run() {
       saleTicket();
    }
    public synchronized void saleTicket() {
        while(true){
                if(tickit > 0){
                    String name = Thread.currentThread().getName();
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(name+":"+tickit--);
                }
            }

        }

}


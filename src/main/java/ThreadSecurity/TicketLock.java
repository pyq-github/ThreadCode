package ThreadSecurity;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketLock implements  Runnable{
    private int ticket = 100;
    private Lock lock = new ReentrantLock(true);
    @Override
    public void run() {
           while(true){
               lock.lock();
               try{
                   if(ticket > 0){
                       String name = Thread.currentThread().getName();
                       try {
                           Thread.sleep(100);
                       } catch (InterruptedException e) {
                           e.printStackTrace();
                       }
                       System.out.println(name+":"+ticket--);
                   }
               } finally {
                   lock.unlock();
               }
           }
    }
}

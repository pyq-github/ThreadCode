package ThreadControll;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

//演示线程之间出现非原子性的问题这里以i++为例
public class AtomicQuestion{
    //private static int n ;
    //static AtomicInteger n ;
      static AtomicStampedReference<Integer> n;
    public static void main(String[] args) throws InterruptedException {
        int j = 0 ;
        while (j<100){
           // n = new AtomicInteger(0);
            n = new AtomicStampedReference(0,0);
            Thread thread1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    int stamp ;
                    Integer reference;
                    for(int i = 0 ;i<1000;i++){
                        //n++;
                        do{
                            stamp  = n.getStamp();
                            reference =  n.getReference();
                        }while(!n.compareAndSet(reference,reference+1,stamp,stamp+1));
                    }
                }
            });
            Thread thread2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ;i<1000;i++){
                       // n++;
                      int stamp;
                      Integer reference;
                      do{
                          stamp  = n.getStamp();
                          reference =  n.getReference();
                      }while(!n.compareAndSet(reference,reference+1,stamp,stamp+1));
                    }
                }
            });
            thread1.start();
            thread2.start();
            thread1.join();
            thread2.join();
            System.out.println("n的数值为："+n.getReference());
            j++;
        }

    }
}

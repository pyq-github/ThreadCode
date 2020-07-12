package ThreadSecurity;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {
    static AtomicInteger n;
    public static void main(String[] args) throws InterruptedException {

        TicketLock tk = new TicketLock();
        Thread threadLock = new Thread(tk);
        Thread threadLock1 = new Thread(tk);
        threadLock.start();
        threadLock1.start();


    }
}

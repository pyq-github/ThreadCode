package NewThread;

import java.util.Date;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ExecutionException, InterruptedException {
        MyThreead thread = new MyThreead();
        Thread threads = new Thread(new myRunnable());
        FutureTask<String> ftask = new FutureTask<String>(new myCallable());
        Thread threadt = new Thread(ftask);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(new myRunnable());
        thread.start();
        threads.start();
        threadt.start();
        ftask.get();
        System.out.println(ftask.get());
        for(int i=0;i<=10;i++){
            System.out.println( "Hello World!；"+new Date().getTime() );



        }
    }
}

package NewThread;

import java.util.Date;
import java.util.concurrent.Callable;

public class myCallable implements Callable<String> {
    @Override
    public String call() throws Exception {
        for(int i = 0;i<=10;i++){
            System.out.println(Thread.currentThread().getName()+"callable执行了"+new Date().getTime());
        }
        return "MyCallable接口执行完成！！";
    }
}

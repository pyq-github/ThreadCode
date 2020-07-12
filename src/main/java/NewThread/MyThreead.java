package NewThread;

import java.util.Date;

public class MyThreead extends Thread{
    public void run(){
        for(int i = 0;i<=10;i++ ){
            System.out.println("MyThread"+new Date().getTime());
        }
    }

}

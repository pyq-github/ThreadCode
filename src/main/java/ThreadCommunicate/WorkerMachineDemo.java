package ThreadCommunicate;

import java.util.concurrent.Semaphore;

public class WorkerMachineDemo {

    static class Worker implements Runnable{
        private int workerNum ;
        private Semaphore semaphore;
        public Worker(int workerNum,Semaphore semaphore){
            this.workerNum = workerNum;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                //工人去获取机器
                semaphore.acquire();
                String name = Thread.currentThread().getName();
                System.out.println("工人"+name+"获取到机器开始工作");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("工人"+name+"工作结束释放机器");
                //释放机器
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        int workers = 8;
        Semaphore semaphore = new Semaphore(3);
        for(int i = 0;i<=8;i++){
            new Thread(new Worker(i,semaphore)).start();
        }
    }
}

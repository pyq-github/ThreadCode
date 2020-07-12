package ThreadControll;
//这是一个两个线程银行存钱的例子
public class ThreadLocalDemo {
    //1.创建Bank对象
    static class Bank{
        private ThreadLocal<Integer> threadLocal = new ThreadLocal<Integer>(){
            protected Integer initialValue(){
                return 5;
            }
        };
        public Integer get(){
            return threadLocal.get();
        }
        public void set(Integer money){
            threadLocal.set(threadLocal.get()+money);
        }
    }
    //2.创建转账对象
   static class Transfer implements Runnable{
        private Bank bank;
        public Transfer(Bank bank){
            this.bank = bank;
        }
        @Override
        public void run() {
            for(int i = 0;i<=8;i++){
                bank.set(100);
                System.out.println("当前线程为："+Thread.currentThread().getName()+",账户金额为:"+bank.get());
            }
        }
    }
    //3.main方法调用
    public static void main(String[] args) {
            Bank bank = new Bank();
            Transfer transfer = new Transfer(bank);
            Thread t1 = new Thread(transfer);
            Thread t2 = new Thread(transfer);
            t1.start();
            t2.start();
    }
}

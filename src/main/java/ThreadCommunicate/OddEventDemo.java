package ThreadCommunicate;

public class OddEventDemo {
    private int i = 0;
    private Object obj = new Object();

  public void odd(){
      while(i<10){
          synchronized (obj){
              if(i%2 == 0){
                  System.out.println("偶数："+i);
                  i++;
                  obj.notify();
              }else{
                  try {
                      obj.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }

          }
      }
  }
  public void jdd(){
      while(i<10){
          synchronized (obj){
              if(i%2 == 1){
                  System.out.println("奇数："+i);
                  i++;
                  obj.notify();
              }else{
                  try {
                      obj.wait();
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
              }

          }
      }
  }

    public static void main(String[] args) {
      final OddEventDemo ode = new OddEventDemo();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                ode.odd();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                ode.jdd();
            }
        });
        t1.start();
        t2.start();
    }
}

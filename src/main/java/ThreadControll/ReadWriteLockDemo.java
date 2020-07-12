package ThreadControll;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;
//这个例子的做用就是在多线程访问Map数据的时候提供的一种读写锁从而保证数据的准确性
public class ReadWriteLockDemo {
        //创建读写锁对象
        private ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        //读锁对象
        private ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();
        //写锁对象
        private ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
        private Map<String,String> map = new HashMap<String, String>();

    public String get(String key){
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"读操作已经加锁，开始读取");
            Thread.sleep(3000);
            map.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"读操作已经解锁");
            readLock.unlock();
        }
        return map.get(key);
    }
    public void put(String key,String value){
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+"写操作已经加锁，开始写入");
            Thread.sleep(3000);
            map.put(key,value);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            System.out.println(Thread.currentThread().getName()+"写操作已经解锁");
            writeLock.unlock();
        }

    }

    public static void main(String[] args) {
        final ReadWriteLockDemo readWriteLockDemo = new ReadWriteLockDemo();
        readWriteLockDemo.put("key1","value2");

        new Thread("Thread2"){
            @Override
            public void run() {
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
        new Thread("Thread3"){
            @Override
            public void run() {
                System.out.println(readWriteLockDemo.get("key1"));
            }
        }.start();
        new Thread("Thread4"){
            @Override
            public void run() {
                readWriteLockDemo.put("key1","ValueX");
            }
        }.start();
    }
}

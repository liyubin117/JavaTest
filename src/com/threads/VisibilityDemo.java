package com.threads;

//内存可见性
/**在计算机系统中，除了内存，数据还会被缓存在CPU的寄存器以及各级缓存中，当
 * 访问一个变量时，可能直接从寄存器或CPU缓存中获取，而不一定到内存中去取，
 * 当修改一个变量时，也可能是先写到缓存中，而稍后才会同步更新到内存中。
 * 在单线程的程序中，这一般不是个问题，但在多线程的程序中，尤其是在有多CPU的情况下，这就是个严重的问题。
 * 一个线程对内存的修改，另一个线程看不到，一是修改没有及时同步到内存，二是另一个线程根本就没从内存读。
 * 解决方法：
 * 	•使用volatile关键字
 * 	•使用synchronized关键字或显式锁同步 
 */
public class VisibilityDemo {
    private static boolean shutdown = false;
    
    static class HelloThread extends Thread {
        @Override
        public void run() {
            while(!shutdown){
                // do nothing
            }
            System.out.println("exit hello");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        new HelloThread().start();
        Thread.sleep(1000);
        shutdown = true;
        System.out.println("exit main");
    }
}
package Runnable;

public class Main {
    public static void main(String[] args) {
        CountingThread2 t1 = new CountingThread2();
        Thread thread1 = new Thread(t1, "Thread 1");
        CountingThread2 t2 = new CountingThread2();
        Thread thread2 = new Thread(t2, "Thread 2");
        CountingThread2 t3 = new CountingThread2();
        Thread thread3 = new Thread(t3, "Thread 3");


        thread1.start();
        thread2.start();
        thread3.start();
    }
}
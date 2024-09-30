package Runnable;

public class CountingThread2 implements Runnable {

    @Override
    public void run() {
        for (int i = 1; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName() + " counted: " + i);
        }
    }
}

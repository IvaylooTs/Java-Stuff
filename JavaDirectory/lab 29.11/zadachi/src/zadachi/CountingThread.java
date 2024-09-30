package zadachi;

public class CountingThread extends Thread{
    @Override
    public void run() {
        for (int i = 1; i<=500; i++){
            System.out.println(Thread.currentThread().getName() + " counted: " + i);
        }
    }
}

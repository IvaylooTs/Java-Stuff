package zadachi;

public class Main {
    public static void main(String[] args) {
        CountingThread t1 = new CountingThread();
        CountingThread t2 = new CountingThread();
        CountingThread t3 = new CountingThread();

        t1.start();
        t2.start();
        t3.start();
    }
}
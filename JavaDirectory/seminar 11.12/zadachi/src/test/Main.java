package test;

import java.util.InputMismatchException;

public class Main {

    static private final Object lock = new Object();
    static int a =0;
    public static void main(String[] args) {
        Runnable r = () ->
        {
            synchronized (lock) {
                for (int i=0; i<100000; i++) {
                    a++;
                }
            }
        };

        Thread t1 = new Thread(r);
        Thread t2 = new Thread(r);

        try {
            t1.start();
            t2.start();
            t1.join();

            t2.join();

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(a);

    }
}
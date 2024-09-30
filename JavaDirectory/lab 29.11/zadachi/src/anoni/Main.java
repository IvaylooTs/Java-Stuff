package anoni;

public class Main {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            public void run(){
                for (int i = 1; i <= 50; i++) {
                    System.out.println(Thread.currentThread().getName() + " counted: " + i);
                }
            }
        };

        Thread t2 = new Thread(){
            public void run(){
                for (int i = 1; i <= 50; i++) {
                    System.out.println(Thread.currentThread().getName() + " counted: " + i);
                }
            }
        };
        Thread t3 = new Thread(() -> {
            for (int i = 0; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName() + " counted: " + i);
            }
        });

        Runnable r1 = () -> {
            for (int i = 0; i <= 50; i++) {
                System.out.println(Thread.currentThread().getName() + " counted = " + i);
            }
        };
        Runnable r2 = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 50; i++) {
                    System.out.println(Thread.currentThread().getName() + " counted = " + i);
                }
            }
        };

        Thread runnableThread1 = new Thread(r1);
        Thread runnableThread2 = new Thread(r2);

        runnableThread1.start();
        runnableThread2.start();

        t1.start();
        t2.start();
        t3.start();


    }
}

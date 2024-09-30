package upr10;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        for (int i=0; i<500; i++){
            System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }

}

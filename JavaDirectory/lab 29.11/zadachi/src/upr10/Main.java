package upr10;

public class Main {
    public static void main(String[] args) throws InterruptedException {

//        StringBuilder grades = new StringBuilder();
//        StringBuffer grades = new StringBuffer();
        Grades grades = new Grades();
        MyThread t1 = new MyThread(grades);
        MyThread t2 = new MyThread(grades);
        MyThread t3 = new MyThread(grades);

        t1.start();
        t2.start();
        t3.start();
        t1.join();
        t2.join();
        t3.join();
//        System.out.println(grades);
//        System.out.println(grades.length());
        System.out.println(grades.getGrades());
        System.out.println(grades.getGrades().length());
    }
}

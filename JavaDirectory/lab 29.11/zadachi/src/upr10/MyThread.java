package upr10;

import java.util.Random;

import java.util.Random;

public class MyThread extends Thread{
    //    private StringBuilder grades;
//    private StringBuffer grades;
    private Grades grades;

    private static Random rand = null;
    public MyThread(Grades grades){
        this.grades = grades;
        rand = new Random();
    }

    public void run() {
        for (int i=1; i<=500; i++){
            int grade = rand.nextInt(5)+2;
//            synchronized (grades){
            grades.addGrades(grade);}
//        }
    }

    @Override
    public String toString() {
        return "MyThread{" +
                "grades=" + grades +
                '}';
    }
}
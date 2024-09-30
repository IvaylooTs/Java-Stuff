package upr10;

import java.util.Random;

public class Grades {
    private final StringBuilder grades;
//    private Random gen;

    public Grades() {
        grades = new StringBuilder();
    }
    public String getGrades(){
        return this.grades.toString();
    }
    public synchronized void addGrade(int grade){
//        int grade = gen.nextInt(5)+2;
        grades.append(grade);
    }

    public void addGrades(int grade){
        synchronized (this){
//            int grade = gen.nextInt(5)+2;
            grades.append(grade);
        }
    }
}



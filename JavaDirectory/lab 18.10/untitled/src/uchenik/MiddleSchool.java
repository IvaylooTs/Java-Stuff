package uchenik;
import java.util.*;

public class MiddleSchool extends Student {
    private static int counter;
    private final int number;
    public MiddleSchool(int number){
            ++counter;
            number = counter;
            this.number = number;

    }
    public MiddleSchool(){
        ++counter;
        number = counter;
    }
    private double grade;

    public double getGrade(){
        return grade;
    }
    public void setGrade(double grade){
        this.grade = grade;
    }

    public double division(double a, double b){
        return a/b;
    }
    public double Multiplication(double a, double b){
        return a*b;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public int getNumber() {
        return super.getNumber();
    }

    @Override
    public String getTeacher() {
        return super.getTeacher();
    }

    @Override
    public void setTeacher(String teacher) {
        super.setTeacher(teacher);
    }

    @Override
    public String toString() {
        return "MiddleShool{" +
                "number=" + number +
                ", name='" + super.getName() + '\'' +
                ", teacher='" + super.getTeacher() + '\'' +
                "grade=" + grade +
                '}';
    }
}

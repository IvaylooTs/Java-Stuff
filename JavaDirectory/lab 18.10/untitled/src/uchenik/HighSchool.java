package uchenik;
import java.util.*;

public class HighSchool extends MiddleSchool{
    private static int counter;
    private final int number;
    public HighSchool(int number){
        ++counter;
        number = counter;
        this.number = number;
    }
    public HighSchool(){
        ++counter;
        number = counter;
    }
    @Override
    public double getGrade() {
        return super.getGrade();
    }

    @Override
    public void setGrade(double grade) {
        super.setGrade(grade);
    }

    @Override
    public double division(double a, double b) {
        return super.division(a, b);
    }

    @Override
    public double Multiplication(double a, double b) {
        return super.Multiplication(a, b);
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
        return "HighSchool{" +
                "number=" + number +
                ", name='" + super.getName() + '\'' +
                ", teacher='" + super.getTeacher() + '\'' +
                "grade=" + super.getGrade() +
                '}';
    }

    public double sinus(double a){
        return Math.sin(a);
    }
    public double cosin(double a){
        return Math.cos(a);
    }

}

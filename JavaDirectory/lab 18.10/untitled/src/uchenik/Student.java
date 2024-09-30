package uchenik;
public class Student {

    private static int counter;
    private final int number;
    private String name;
    private String teacher;

    public Student() {
        ++counter;
        number = counter;

    }
    public Student(int number) {
        ++counter;
        number = counter;
        this.number = number;
    }
    public String getName() { return name; }
    public void setName(String name) {this.name = name;}
    public int getNumber() {return number;}
    public String getTeacher() {
        return teacher;
    }
    public void setTeacher(String teacher) {this.teacher = teacher;}

    public double subtract(double a, double b){
        return a-b;
    }
    public double sum(double a, double b){
        return a+b;
    }

    @Override
    public String toString() {
        return "Student{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", teacher='" + teacher + '\'' +
                '}';
    }
}

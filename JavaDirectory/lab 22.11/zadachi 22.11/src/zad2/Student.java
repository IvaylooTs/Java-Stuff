package zad2;

import java.lang.ref.Cleaner;
import java.util.Comparator;
import java.util.Objects;

public class Student implements Comparable<Student>, AutoCloseable, Cleaner.Cleanable {
    private String name;
    private Integer grade;

    private static int count;

    private static final Cleaner cleaner = Cleaner.create();

    public static int getCount(){
        return count;
    }


    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGrade(int grade){
        this.grade = grade;
    }
    public int getGrade(){
        return grade;
    }

    public Student(String name, Integer grade){
        cleaner.register(this, this::clean);
        this.name = name;
        this.grade = grade;
        count++;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student student)) return false;
        return Objects.equals(name, student.name) && Objects.equals(grade, student.grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", grade=" + grade +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        if (this.grade>o.grade) {
            return 1;
        } else if (this.grade<o.grade) {
        return -1;
        } else {
            return 0;
        }
    }

    @Override
    public void close(){
        count--;
    }


    @Override
    public void clean() {
        System.gc();
        count--;
    }
}


package zad2;

import java.util.ArrayList;

public class Main3 implements AutoCloseable {
    public static void main(String[] args) {
        Student student5 = new Student("Go", 4);
        Student student6 = new Student("Go", 4);
        Student student7 = new Student("Go", 4);
        ArrayList<Student> students1 = new ArrayList<>();
        students1.add(student5);
        students1.add(student6);
        students1.add(student7);


    }

    @Override
    public void close() throws Exception {
        int count = 0;
        count--;
    }
}

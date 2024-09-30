package zad2;
import java.lang.reflect.Array;
import java.util.*;

public class Main2 {
    public static void main(String[] args) {
        Student student1 = new Student("Ivan", 4);
        Student student2 = new Student("Go", 4);
        Student student3 = new Student("Ti", 6);
        Student student4 = new Student("Az", 2);
        List<Student> arrayL2 = new ArrayList<>();
        arrayL2.add(student1);
        arrayL2.add(student2);
        arrayL2.add(student3);


        LinkedList<Student> linkedL2 = new LinkedList<>();
        linkedL2.add(student1);
        linkedL2.add(student2);
        linkedL2.add(student3);

        Set<Student> HS2 = new HashSet<>();
        HS2.add(student1);
        HS2.add(student2);
        HS2.add(student3);

        Set<Student> linkedHSet2 = new LinkedHashSet<>();
        linkedHSet2.add(student1);
        linkedHSet2.add(student2);
        linkedHSet2.add(student3);


        Map <Integer, Student> hashMap2 = new HashMap<>();
        hashMap2.put(1,student1);
        hashMap2.put(2,student2);
        hashMap2.put(3,student3);


        System.out.println("ArrayL: "+ arrayL2);
        System.out.println("LinkedL" +linkedL2);
        System.out.println("LinkedHSet: "+ linkedHSet2);
        System.out.println("HS: "+ HS2);
        System.out.println("HashMap: "+ hashMap2);

        System.out.println("ArrayL contains:" + arrayL2.contains(student1));
        System.out.println("ArrayL index: "+ arrayL2.indexOf(student1));
        System.out.println("Array 0 index equals: "+ arrayL2.get(0).equals(student1));
        System.out.println("ArrayL remove: "+ arrayL2.remove(student1));

        ArrayList<Student> students = new ArrayList<>();
        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        System.out.println(students);
        students.sort(null);

        System.out.println(students);

        Comparator <Student> comparator = (o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName());
        students.sort(comparator);
        System.out.println(students);
        System.out.println(Student.getCount());
        student1.clean();
        student2.clean();
        System.out.println(Student.getCount());

//        System.gc();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        System.out.println(Student.getCount());

//        Comparator <Student> comparator = new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o1.getName().compareToIgnoreCase(o2.getName());
//            }
//        };
//        students.sort(comparator);
//        System.out.println(students);


    }

}
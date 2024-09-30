public class Student {
    public static void main(String[] args) {

        uchenik.Student Uchenik1 = new uchenik.Student(1);
        Uchenik1.setName("Ivan") ;
        Uchenik1.setTeacher("Gosho");

        uchenik.Student Uchenik2 = new uchenik.Student(1);
        Uchenik2.setName("Stefan");

        uchenik.MiddleSchool Uchenik3 = new uchenik.MiddleSchool(1);
        uchenik.MiddleSchool Uchenik4 = new uchenik.MiddleSchool(1);
        Uchenik4.setName("Da");
        Uchenik4.setGrade(5);

        uchenik.HighSchool Uchenik5 = new uchenik.HighSchool(1);
        uchenik.MiddleSchool Uchenik6 = new uchenik.HighSchool(1);

        System.out.println(Uchenik1.toString() + " Sum: " + Uchenik1.sum(2,3));
        System.out.println(Uchenik2.toString());
        System.out.println(Uchenik3.toString() + " Multi: " + Uchenik3.Multiplication(2,3));
        System.out.println(Uchenik4.toString());
        System.out.println(Uchenik5.toString()+ " Sin " + Uchenik5.sinus(45));
        System.out.println(Uchenik6.toString());
    }
}
package zad1;

public class Main {
    public static void main(String[] args) {
        CompanyET company1 = new CompanyET();
        company1.setActualCapital(1000);
        company1.setStartCapital(100);
        System.out.println(company1.earnings());
    }
}
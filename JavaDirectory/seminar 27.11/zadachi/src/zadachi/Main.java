package zadachi;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Voter> list = new ArrayList<>();

        list.add(new Voter("Georgi Georgiev", "Sofia", "Stefan Stambolov", "132"));
        list.add(new Voter("Ivan Ivanov", "Sofia", "Stefan Stambolov", "nom. 132"));
        list.add(new Voter("Gosho gosho", "Varna", "Stefan Stambolov", "nom. 132"));
        list.add(new Voter("Krum krum", "Sofia", "Stefan Stambolov", "nom. 132"));
        list.add(new Voter("Plamen Peshev", "Petrich", "Stefan Stambolov", "nom. 132"));
        System.out.println(list.stream().filter(voter -> voter.getCity().equals("Sofia"))
                .sorted(Comparator.comparing(Voter::getStreet).thenComparing(Voter::getAddress)).toList());

    }
}
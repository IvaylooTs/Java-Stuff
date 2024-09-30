package zadachi;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> arrayL = new ArrayList<>();
        arrayL.add(2);
        arrayL.add(2);
        arrayL.add(5);
        arrayL.add(4);
        arrayL.add(3);
        arrayL.add(6);

        LinkedList<Integer> linkedL = new LinkedList<>();
        linkedL.add(6);
        linkedL.add(2);
        linkedL.add(2);
        linkedL.add(4);
        linkedL.add(5);
        linkedL.add(6);

        Set<Integer> HS = new HashSet<>();
        HS.add(4);
        HS.add(2);
        HS.add(3);
        HS.add(4);
        HS.add(5);
        HS.add(6);

        Set<Integer> linkedHSet = new LinkedHashSet<>();
        linkedHSet.add(3);
        linkedHSet.add(2);
        linkedHSet.add(3);
        linkedHSet.add(4);
        linkedHSet.add(5);
        linkedHSet.add(6);

        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(4);
        treeSet.add(2);
        treeSet.add(3);
        treeSet.add(4);
        treeSet.add(6);
        treeSet.add(6);

        Map <Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1,1);
        hashMap.put(2,4);
        hashMap.put(3,2);
        hashMap.put(4,4);
        hashMap.put(5,6);
        hashMap.put(6,6);

        System.out.println(arrayL.indexOf(6));
        while (arrayL.contains(2)){
            arrayL.remove((Integer) 2);
        }
        for (Integer i:HS) {
            System.out.println("Numbers HS: " +i);
        }
        for (Integer i:arrayL) {
            System.out.println("arrayL: " +i);
        }
        for (Integer i:linkedL) {
            System.out.println("linkedL: " +i);
        }
        for (Integer i:linkedHSet) {
            System.out.println("linkedHSet: " +i);
        }
        for (Integer i:treeSet) {
            System.out.println("treeset: " +i);
        }
        System.out.println(hashMap);
    }
}
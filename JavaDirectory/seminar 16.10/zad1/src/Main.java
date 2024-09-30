import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[] {1, 2, 5, 20, 16, 7, 10};
        System.out.println(Arrays.toString(sortAndFilter(arr,5)));
        System.out.println(Arrays.toString(arr));
    }



    static int[] sortAndFilter(int[] array, int key) {
        int count = 0;

        for (int i=0;i<array.length;i++){
            if (array[i]<=key) {
                count++;
            }

        }
        int[] copy = new int[count];
        for (int i=0, j=0; i<array.length; i++) {
            if(array[i]<=key) {
                copy[j] = array[i];
                j++;
            }
        }
        Arrays.sort(copy);

        return copy;
    }
}
package mergesortedarrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSortedArrays {

    public static void main(String[] args) {

        List<Integer> a = Arrays.asList(1, 5, 7, 7);
        List<Integer> b = Arrays.asList(0, 1, 2, 3, 5, 12);

        List<Integer> result = mergeArrays(a, b);

        result.forEach(System.out::print);
    }

    public static List<Integer> mergeArrays(List<Integer> array1, List<Integer> array2) {

        List<Integer> list = new ArrayList<>();

        int i = 0;
        int j = 0;
        while (i < array1.size() && j < array2.size()) {
            if (array1.get(i) < array2.get(j)) {
                list.add(array1.get(i));
                i++;
            } else {
                list.add(array2.get(j));
                j++;
            }
        }

        //add remaining of array1
        while (i < array1.size()) {
            list.add(array1.get(i));
            i++;
        }
        //add remaining of array2
        while (j < array2.size()) {
            list.add(array2.get(j));
            j++;
        }

        return list;
    }

}

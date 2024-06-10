import java.util.ArrayList;
import java.util.List;

public class MergeSortedLists {
    public static List<Integer> mergeAndRemoveDuplicates(List<Integer> l1, List<Integer> l2) {
        List<Integer> result = new ArrayList<>();
        int i = 0, j = 0;

        while (i < l1.size() && j < l2.size()) {
            int val1 = l1.get(i);
            int val2 = l2.get(j);

            if (val1 < val2) {
                if (!result.contains(val1)) {
                    result.add(val1);
                }
                i++;
            } else if (val2 < val1) {
                if (!result.contains(val2)) {
                    result.add(val2);
                }
                j++;
            } else {
                if (!result.contains(val1)) {
                    result.add(val1);
                }
                i++;
                j++;
            }
        }

        while (i < l1.size()) {
            int val = l1.get(i);
            if (!result.contains(val)) {
                result.add(val);
            }
            i++;
        }

        while (j < l2.size()) {
            int val = l2.get(j);
            if (!result.contains(val)) {
                result.add(val);
            }
            j++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> l1 = List.of(1, 3, 5, 7);
        List<Integer> l2 = List.of(2, 3, 6, 7);

        List<Integer> mergedList = mergeAndRemoveDuplicates(l1, l2);
        System.out.println("Merged and unique list: " + mergedList);
    }
}

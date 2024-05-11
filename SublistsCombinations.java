import java.util.ArrayList;
import java.util.List;

public class SublistsCombinations {

    public static void main(String[] args) {
        List<Integer> originalList = new ArrayList<>();
        originalList.add(1);
        originalList.add(2);
        originalList.add(3);

        List<List<Integer>> sublists = generateSublists(originalList);

        // Print the generated sublists
        for (List<Integer> sublist : sublists) {
            System.out.println(sublist);
        }
    }

    public static List<List<Integer>> generateSublists(List<Integer> originalList) {
        List<List<Integer>> sublists = new ArrayList<>();
        int n = originalList.size();

        // Generate all possible sublists using bitmasking
        for (int i = 0; i < (1 << n); i++) {
            List<Integer> sublist = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i & (1 << j)) > 0) {
                    sublist.add(originalList.get(j));
                }
            }
            sublists.add(sublist);
        }
        return sublists;
    }
}

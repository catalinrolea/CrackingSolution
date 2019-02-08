package recursion;

import java.util.ArrayList;

public class SubsetsFromSet {

    ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
        ArrayList<ArrayList<Integer>> allSubsets;
        if (set.size() == index) {
            allSubsets = new ArrayList<ArrayList<Integer>>();
            allSubsets.add(new ArrayList<>());
        } else {
            allSubsets = getSubsets(set, index + 1);
            int item = set.get(index);
            ArrayList<ArrayList<Integer>> moreSusets = new ArrayList<ArrayList<Integer>>();
            for (ArrayList<Integer> subset : allSubsets) {
                ArrayList<Integer> newSubset = new ArrayList<>();
                newSubset.addAll(subset);
                newSubset.add(item);
                moreSusets.add(newSubset);
            }
            allSubsets.addAll(moreSusets);
        }
        return allSubsets;
    }


    public static void main(String[] args) {
        SubsetsFromSet subsetsFromSet = new SubsetsFromSet();

        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
       // set.add(3);
        System.out.println(subsetsFromSet.getSubsets(set,0));

    }
}

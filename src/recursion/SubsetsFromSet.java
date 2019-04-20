package recursion;

import org.apache.log4j.Logger;
import org.apache.tools.ant.SubBuildListener;
import org.junit.Test;

import java.util.ArrayList;

/*
    n=0 ==> {}
    n=1 ==> {}, {a1}
    n=2 ==> {}, {a1}, {a2}, {a1, a2}
 */
public class SubsetsFromSet {
    final static Logger logger = Logger.getLogger(SubsetsFromSet.class);

    ArrayList<ArrayList<Integer>> retrieveSubset(ArrayList<Integer> set, int index) {

        ArrayList<ArrayList<Integer>> result;
        if (set.size() == index) {
            result = new ArrayList<ArrayList<Integer>>();
            result.add(new ArrayList<>());
        } else {
            result = retrieveSubset(set, index + 1);
            ArrayList<ArrayList<Integer>> listOfList = new ArrayList<>();
            ArrayList<Integer> subsetList;

            for (ArrayList<Integer> results : result) {
                subsetList = new ArrayList<>();
                subsetList.add(set.get(index));
                subsetList.addAll(results);
                listOfList.add(subsetList);
            }
            result.addAll(listOfList);

        }

        return result;
    }


    @Test
    public void testSubsetFromSet() {

        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(1);
        subset.add(2);
        subset.add(3);
        for (ArrayList index : retrieveSubset(subset, 0)) {
            logger.info("index: " + index);
        }

    }
}
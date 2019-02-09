package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.*;

/*
1.1 Permutation without duplicates
1.2 Permutation with duplicates
 */
public class PermutationWIthoutDups {

    private static final Logger logger = Logger.getLogger( PermutationWIthoutDups.class.getName() );


    ArrayList<String> getAllPermutation(String str) {



        ArrayList<String> result = new ArrayList<>();
        if (str.length() == 0) {
            result.add("");
            return result;
        }
        ArrayList<String> permutations = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String before = str.substring(0, i);
            String after = str.substring(i + 1, str.length());
            permutations = getAllPermutation(before + after);
            for (String s : permutations) {
                  result.add(str.charAt(i) + s);
            }
        }


        return result;
    }

    @Test
    public void test() {
        String str = "abc";
        Set<String> set = new HashSet<>();
        for (String index : getAllPermutation(str)) {
             logger.info(index);
             set.add(index);
        }
        logger.info("-------------------");
        for (String index : set){
            logger.info(index);
        }

    }
}
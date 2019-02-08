package recursion;

import org.junit.Test;

import java.util.ArrayList;
import java.util.logging.Logger;

public class PermutationWIthoutDups {

    private final static Logger logger = Logger.getLogger(PermutationWIthoutDups.class.getName());

    ArrayList<String> getAllPermutation(String str) {
        int len = str.length();
        ArrayList<String> result = new ArrayList<>();
        if (len == 0) {
            result.add("");
            return result;
        }
        for (int i = 0; i < len; i++) {
            //remove char i and find permutations of remaining chars
            String before = str.substring(0, i);
            String after = str.substring(i + 1, len);
            ArrayList<String> partial = getAllPermutation(before + after);
            for (String s : partial) {
                result.add(str.charAt(i) + s);
            }
        }

        return result;
    }

    @Test
    public void test() {
        String str = "ab";
        for (String index : getAllPermutation(str)){
            logger.info(index);
        }

    }
}
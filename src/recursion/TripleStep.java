package recursion;

import org.junit.Test;

public class TripleStep {

    int countWays(int n) {
        if (n<0)
            return 0;
        if (n==0)
            return 1;
        else {
            return countWays(n-1) + countWays(n-2) + countWays(n-3);
        }
    }

    @Test
    public void testTripleStep(){
        int n=3;
        System.out.println(countWays(n));
    }
}

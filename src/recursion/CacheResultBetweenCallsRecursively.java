package recursion;

import org.apache.log4j.Logger;
import org.junit.Test;

public class CacheResultBetweenCallsRecursively {
    final static Logger logger = Logger.getLogger(CacheResultBetweenCallsRecursively.class);


    // Old implementation when f(n) appear for each call
    public static int fibonacciCall(int n) {
        logger.debug(n);
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return n + fibonacciCall(n - 1);
    }

    int fibonacciMemorization(int n) {
        return fibonacciMemorization(n, new int[n + 1]);
    }

    int fibonacciMemorization(int i, int[] memo) {
        logger.debug(i);
        if (i == 0 || i == 1)
            return i;

        if (memo[i] == 0) {
            memo[i] = fibonacciMemorization(i - 1, memo) + fibonacciMemorization(i - 2, memo);
        }

        return memo[i];
    }

    @Test
    public void testCache() {

        //memorize recursive calls into an array of int[]
        logger.debug(fibonacciMemorization(4));
        //logger.debug(fibonacciCall(3));
    }
}

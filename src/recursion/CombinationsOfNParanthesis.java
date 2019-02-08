package recursion;


public class CombinationsOfNParanthesis {

    static void prinCombinations(int n, int pos, char[] str, int open, int closed) {

        if (closed == n) {
            //print all possible solutions
            for (int i = 0; i < str.length; i++)
                System.out.print(str[i]);
            System.out.println();
            return;
        } else {
            //if open > closed => open '('
            if (open > closed) {
                str[pos] = '(';
                prinCombinations(n, pos + 1, str, open, closed + 1);
            }
            //open will always be higher then '(), so we compare to n
              if (open < n) {
                str[pos] = ')';
                prinCombinations(n, pos + 1, str, open + 1, closed);
            }
        }
    }

    static void standardCombinations(int n, char[] str) {
        if (n > 0)
            prinCombinations(n, 0, str, 0, 0);
        return;
    }

    public static void main(String[] args) {
        int numberOfParanthesis = 3;
        char[] str = new char[2 * numberOfParanthesis];
        standardCombinations(numberOfParanthesis, str);
    }

}

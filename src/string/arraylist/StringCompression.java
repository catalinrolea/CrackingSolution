package string.arraylist;

import org.junit.Test;

public class StringCompression {

    static boolean checkIsLetter(char c) {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(c);
        if (a <= val && val <= z)
            return true;
        return false;
    }

    static String stringCompression(String string) {
        int index = 0, i = 0, countAppeareance = 0;
        StringBuilder sb = new StringBuilder();

        while (i < string.length()) {
            while (index < string.length() && string.charAt(i) == string.charAt(index)) {
                countAppeareance++;
                index++;
            }
            sb.append(string.charAt(i));
            sb.append(countAppeareance);
            i = index;
            countAppeareance = 0;
        }
        if (sb.toString().length() < string.length())
            return string;

        return sb.toString();
    }

    @Test
    public void testCompressionString() {
        String positiveExample = "aab";
        String consExample = "aabcccccaaa";
        System.out.println("Compressed string > initial string: " + stringCompression(positiveExample));
        System.out.println("Compressed string <  initial string: " + stringCompression(consExample));
    }
}

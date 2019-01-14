package string.arraylist;


public class CheckPalindromPermutation {


    static int hashCode(char s) {
        return s - 'a';
    }


    String checkPalindromPermutation(String input) {
        int[] chars = new int[260];
        int oddNumber = 0; //not divided/2
        int evenNumber = 0; // divided/2
        int a = Character.getNumericValue('a');
        int b = Character.getNumericValue('z');
        for (char index : input.toCharArray()) {
             int val = Character.getNumericValue(index);
            if (a <= val && val <= b) {
                chars[hashCode(index)]++;
            }

        }
        for (int index : chars) {
            if (index != -1) {
                if (index % 2 == 1) {
                    oddNumber++;
                } else {
                    evenNumber++;
                }
            }
        }
        if (oddNumber > 1) {
            System.out.println("oddNumber > 1: no palindrom permutation");
        } else {
            System.out.println("oddNumber = 0: palindrom permutation");
        }
        System.out.println("OddNumber: " +oddNumber);
        System.out.println("evenNumber: " + evenNumber);

        return "";
    }

    public static void main(String[] args) {

        String noPalPermutation = "aabbcceeeeef";
        String palPermutation = "aabbcceeeee";
        CheckPalindromPermutation object = new CheckPalindromPermutation();
        object.checkPalindromPermutation(palPermutation);


    }
}

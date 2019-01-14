package string.arraylist;

import org.junit.Test;

public class CheckPalindromPermutationSimplifySolution {

    //transform characters in asci hexa value + check if character is word between a-z

     static int getAsciValue(char input)  {
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(input);
        if (a <= val && val <= z)   {
            return input-'a';
        }
        return  -1;
     }

     static boolean checkPalindromPermutation(String input) {
         //create char of all letters between a-z
         int []charArray = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
         int oddNumber = 0; //not divided/2
         for (char character : input.toCharArray()) {
             int letterASCIValue = getAsciValue(character);
             //need to be different then 0
             if (letterASCIValue != -1) {
                 charArray[letterASCIValue]++;
                 if (charArray[letterASCIValue] %2 ==1) {
                     oddNumber++;
                 } else {
                     oddNumber--;
                 }
             }

         }
         boolean checkFinalOddNumber = oddNumber <= 1;
         return checkFinalOddNumber;
     }


    @Test
    public void testPalindromPermutation() {
        String input = "aabbcceeeee";
        if (checkPalindromPermutation(input)==false)  {
            System.out.println("Input is NOT a permutation of palindrom");
        } else {
            System.out.println("Input is a permutation of palindrom");
        }
    }
}

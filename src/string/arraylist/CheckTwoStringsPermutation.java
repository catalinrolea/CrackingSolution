package string.arraylist;

import java.util.Arrays;

public class CheckTwoStringsPermutation {

   String sort(String s)    {
       char[] content = s.toCharArray();
        Arrays.sort(content);
        String sortedString = new String(content);
       return sortedString;
   }

     boolean isPermutation(String s1, String s2)  {
       if (s1.length() != s2.length())  {
           return false;
       }
       boolean flag = sort(s1).equals(sort(s2));
       return flag;
   }

   public static void main(String[] args)   {
        String s1 = "abc";
        String s2 = "abc";
        CheckTwoStringsPermutation check = new CheckTwoStringsPermutation();
        if (check.isPermutation(s1,s2))   {
            System.out.println("Strings are permutations! ");
        } else {
            System.out.println("Strings are  NOT permutations! ");
        }
    }
}

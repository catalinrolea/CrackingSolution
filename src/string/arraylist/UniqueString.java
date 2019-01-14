package string.arraylist;

import java.util.*;

public class UniqueString {

    static int hashCode(int s) {

        return s - 'a';
    }
    static boolean isUnique(String s) {
        int array[] = new int[s.length()];
        int index=0;
        boolean flag = false;
        boolean visited[] = new boolean[128];
        for (int i=0; i<s.length(); i++)    {

            if (visited[hashCode(s.charAt(i))]) {
                flag = true;
            }
            visited[hashCode(s.charAt(i))] = true;

        }

        return flag;
    }

    public static void main(String[] args)  {
        String s1 = "absa";
         char s2 = 'b';
        if (isUnique(s1))
            System.out.println("Not unique string");
        else
            System.out.println("Unique string");


    }
}

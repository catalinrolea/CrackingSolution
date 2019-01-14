package string.arraylist;

import org.junit.Test;

public class OneEdit_ReplaceInsertDelete_Away {

    static int hashCode(char c) {
        return c - 'a';
    }

    static boolean checkAwayEditReplace(String firstS, String secondS) {

        char[] Frequency = new char[260];
        int countReplacement = 0;
        boolean isReplaced = false;
        if (firstS == null && secondS == null) {
            return false;
        }
        for (int i = 0; i < firstS.length(); i++) {
            Frequency[i] = firstS.charAt(i);
        }
        for (int i = 0; i < secondS.length(); i++) {
            if (secondS.charAt(i) != Frequency[i])
                countReplacement++;
        }
        if (countReplacement <= 1) {
            isReplaced = true;
        }
        return isReplaced;
    }

    static boolean checkAwayEditDelete(String firstString, String secondString) {
        boolean isDeleted = false;
        char[] Frequency = new char[260];
        int countReplacement = 0;
        //need to check even after deletion of one character, there are the same characters
        if (firstString.length() == secondString.length() - 1)
            isDeleted = true;
        for (int i = 0; i < firstString.length(); i++) {
            Frequency[i] = firstString.charAt(i);
        }
        for (int i = 0; i < secondString.length(); i++) {
            if (secondString.charAt(i) != Frequency[i]) {
                countReplacement++;
            }
        }

        if (countReplacement <= 1)
            isDeleted = true;


        return isDeleted;
    }

    static boolean checkAwayEditInsert(String firstString, String secondString) {
        boolean isInserted = false;
        int index1 = 0, index2 = 0, countNrInsert = 0;
        if (firstString.length() == secondString.length() - 1) {
            isInserted = true;
            countNrInsert++;
        }
        while (index1 < firstString.length() && index2 < secondString.length()) {
            if (firstString.charAt(index1) != secondString.charAt(index2)) {
                countNrInsert++;
                index1++;
                if (firstString.charAt(index1) != secondString.charAt(index2)) {
                    countNrInsert++;
                }
            } else {
                index1++;
                index2++;
            }
        }
        System.out.println("countNrInsert: " + countNrInsert);


        return isInserted;
    }

    boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        String s1 = first.length() < second.length() ? first : second;
        String s2 = first.length() < second.length() ? second : first;

        int index1 = 0;
        int index2 = 0;
        boolean foundDifference = false;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (foundDifference)
                    return false;
                foundDifference = true;

                if (s1.length() == s2.length()) {
                    index1++;
                }
            } else {
                index1++;
            }

            index2++;
        }
        return true;
    }


    @Test
    public void oneEditAway() {
        System.out.println("*** One edit away ***");
        String s1 = "ale";
        String s2 = "ae";


        System.out.println("test checkInsert->" + oneEditAway(s1, s2));
    }
}

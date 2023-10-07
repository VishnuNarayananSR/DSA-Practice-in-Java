package strings;

public class OneEditAway {
    public static boolean isOneReplaceAway(String first, String second) {
        boolean replaced = false;
        for (int i = 0; i < first.length(); i++) {
            if (first.charAt(i) != second.charAt(i)) {
                if (replaced) {
                    return false;
                }
                replaced = true;
            }
        }
        return true;
    }

    public static boolean isOneInsertAway(String longer, String shorter) {
        boolean inserted = false;
        for (int i = 0, j = 0; j < shorter.length(); i++, j++) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                if (inserted) {
                    return false;
                }
                inserted = true;
                i++;
            }
        }
        return true;
    }

    /*
    Given two string, determine if they are one edit (or zero edits) away
     */
    public static boolean isOneEditAway(String first, String second) {
        String longer = first.length() > second.length() ? first : second;
        String shorter = first.length() > second.length() ? second : first;
        int longerLen = longer.length();
        int shorterLen = shorter.length();
//        if the length difference is greater than 1, return false
        if (Math.abs(longerLen - shorterLen) > 1) {
            return false;
        }
        boolean foundDifference = false;
        for (int i = 0, j = 0; i < longerLen && j < shorterLen; i++, j++) {
            if (longer.charAt(i) != shorter.charAt(j)) {
                if (foundDifference) {
                    return false;
                }
                if (longerLen != shorterLen) {
                    j--;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isOneEditAway("pale", "bale"));  //true
        System.out.println(isOneEditAway("pale", "ple"));   //true
        System.out.println(isOneEditAway("pales", "pale")); //true
        System.out.println(isOneEditAway("pale", "bake"));  //false
        System.out.println(isOneEditAway("abc", "abde"));  //false
    }
}

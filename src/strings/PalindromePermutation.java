package strings;

public class PalindromePermutation {
    /**
     * Given a string check if it is a permutation of a palindrome.(ignoring special characters)
     */
    public static boolean isPalindromePermutation(String s) {
        int vector = 0;
        for (char ch : s.toCharArray()) {
            int charNumber = getCharNumber(ch);
            if (charNumber > -1) {
                vector ^= 1 << charNumber;
            }
        }
        return vector == 0 || isExactlySingleBitSet(vector);
    }

    public static int getCharNumber(int ch) {
        if (ch >= 'a' && ch <= 'z') {
            return ch - 'a';
        }
        if (ch >= 'A' && ch <= 'Z') {
            return ch - 'A';
        }
        return -1;
    }

    public static boolean isExactlySingleBitSet(int vector) {
        return (vector & (vector - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromePermutation("taco tac"));
        System.out.println(isPalindromePermutation("aaaaaaabae"));
    }
}

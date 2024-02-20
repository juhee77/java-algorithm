package leetcode;

public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0)
            return false;

        int divider = (int) Math.log10(x) + 1;
        int downLine = (int) Math.pow(10, divider - 1);

        for (int i = 0; i < divider / 2; i++) {

            if (x % 10 != x / downLine) {
                return false;
            }

            downLine /= 10;
            x = (x / 10) % downLine; // 앞뒤로 하나씩 날림
            downLine /= 10;
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        System.out.println(palindromeNumber.isPalindrome(-121)+" is false");
        System.out.println(palindromeNumber.isPalindrome(0)+" is true");
        System.out.println(palindromeNumber.isPalindrome(10)+" is false");
        System.out.println(palindromeNumber.isPalindrome(12321)+" is true");

    }
}

package leetcode;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        return (int) binaryString.chars().filter(ch -> ch == '1').count();
    }
}

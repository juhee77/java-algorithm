package interview.java;

public class FourDotTwo_비트스왑 {
    public static void main(String[] args) {
        // 11101
        System.out.println(swapBits(13, 0, 1));
    }

    public static long swapBits(long x, int i, int j) {
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            long bitMask = (1L << i) | (1L << j);
            x ^= bitMask;
        }
        return x;
    }
}

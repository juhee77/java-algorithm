package interview.java;

import java.util.Scanner;

public class FourDotOne_페리티계산하기 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(parity(Long.parseLong(sc.nextLine())));
    }

    public static short parity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);

    }
}

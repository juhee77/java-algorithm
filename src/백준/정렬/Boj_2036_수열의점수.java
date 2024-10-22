package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Boj_2036_수열의점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        List<BigInteger> minusArr = new ArrayList<>();
        List<BigInteger> plusArr = new ArrayList<>();
        boolean hasZero = false;
        BigInteger ones = BigInteger.ZERO;

        while (n-- > 0) {
            BigInteger value = new BigInteger(br.readLine());
            if (value.compareTo(BigInteger.ZERO) > 0) {
                if (value.equals(BigInteger.ONE)) {
                    ones = ones.add(BigInteger.ONE);
                } else {
                    plusArr.add(value);
                }
            } else if (value.compareTo(BigInteger.ZERO) < 0) {
                minusArr.add(value);
            } else {
                hasZero = true;
            }
        }

        Collections.sort(minusArr);
        plusArr.sort(Collections.reverseOrder());

        BigInteger ans = ones;
        ans = ans.add(getMaxScore(minusArr, hasZero));
        ans = ans.add(getMaxScore(plusArr, false));

        System.out.println(ans);
    }

    private static BigInteger getMaxScore(List<BigInteger> arr, boolean hasZero) {
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < arr.size(); i += 2) {
            if (i == arr.size() - 1) {
                if (hasZero && arr.get(i).compareTo(BigInteger.ZERO) < 0) {
                    continue;
                }
                ans = ans.add(arr.get(i));
            } else {
                ans = ans.add(arr.get(i).multiply(arr.get(i + 1)));
            }
        }
        return ans;
    }
}

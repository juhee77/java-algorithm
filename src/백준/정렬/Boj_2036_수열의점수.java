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

        while (n-- > 0) {
            BigInteger value = new BigInteger(br.readLine());
            if (value.compareTo(BigInteger.ZERO) > 0) {
                plusArr.add(value);
            } else if (value.compareTo(BigInteger.ZERO) < 0) {
                minusArr.add(value);
            }
        }

        Collections.sort(minusArr);
        plusArr.sort(Collections.reverseOrder());
        BigInteger ans = BigInteger.ZERO;
        ans = ans.add(getMaxScore(minusArr));
        ans = ans.add(getMaxScore(plusArr));

        System.out.println(ans);
    }

    private static BigInteger getMaxScore(List<BigInteger> arr) {
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < arr.size(); i += 2) {
            if (i == arr.size() - 1) {
                ans = ans.add(arr.get(i));
            } else {
                ans = ans.add(arr.get(i).multiply(arr.get(i + 1)));
            }
        }
        return ans;
    }
}

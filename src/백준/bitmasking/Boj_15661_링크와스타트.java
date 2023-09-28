package 백준.bitmasking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15661_링크와스타트 {
    private static int n;
    private static int total;
    private static int[][] map;
    private static final HashMap<Long, Long> hashMap = new HashMap<>();
    private static long min = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        total = (1 << (n)) - 1;
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(min);
    }

    public static void dfs(int nowDepth, long bitmask) {
        if (min == 0) return;

        if (nowDepth == n) {

            if (hashMap.containsKey(bitmask)) {
                return; //이미 함
            }
            long value = getNum(bitmask);
            hashMap.put(bitmask, value);

            //다른조
            long other = total ^ bitmask;
            long otherValue = getNum(other);
            hashMap.put(other, otherValue);

//            System.out.println("total " + Long.toString(total, 2));
//            System.out.println("now " + Long.toString(bitmask, 2) + " " + value);
//            System.out.println("other " + Long.toString(other, 2) + " " + otherValue);
            min = Math.min(Math.abs(otherValue - value), min);
        } else {
            long next = bitmask << 1;
            //선택하지 않는 경우
            dfs(nowDepth + 1, next);

            //선택하는 경우
            dfs(nowDepth + 1, next + 1);
        }
    }

    private static long getNum(long bitmask) {
        String string = Long.toBinaryString(bitmask);
        int length = string.length();
        int holdLength = n - length; // 11 (0011 이것으로 처리해줘야 해서)

        long value = 0;
        for (int i = 0; i < length; i++) {
            if (string.charAt(i) == '1') {
                for (int j = 0; j < length; j++) {
                    if (string.charAt(j) == '1') {
                        value += map[holdLength + i][holdLength + j];
                    }
                }
            }
        }
        return value;
    }


    private static long getNum2(long bitmask) {
        String string = Long.toString(bitmask, 2);
        char[] charArray = string.toCharArray();
        List<Integer> arr = new ArrayList<>();

        for (int i = charArray.length - 1; 0 <= i; i--) {
            if (charArray[i] == '1') {
                arr.add(charArray.length - i - 1);
            }
        }
//        System.out.println(bitmask + " 의 char은" + string + " " + arr);
        long value = 0;
        for (int i = 0; i < arr.size() - 1; i++) {
            for (int j = i + 1; j < arr.size(); j++) {
                value += map[arr.get(i)][arr.get(j)] + map[arr.get(j)][arr.get(i)];
            }
        }

        return value;
    }
}

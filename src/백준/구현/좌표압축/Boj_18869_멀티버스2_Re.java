package 백준.구현.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_18869_멀티버스2_Re {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int universeCnt = Integer.parseInt(st.nextToken());
        int planetCnt = Integer.parseInt(st.nextToken());

        int[][] map = new int[universeCnt][planetCnt];

        for (int i = 0; i < universeCnt; i++) {
            st = new StringTokenizer(br.readLine());
            int[] arr = new int[planetCnt];
            List<Integer> nums = new ArrayList<>();
            for (int j = 0; j < planetCnt; j++) {
                int num = Integer.parseInt(st.nextToken());
                arr[j] = num;
                nums.add(num);
            }

            map[i] = getRankingMap(arr, nums);
        }

        int ans = 0;
        for (int i = 0; i < universeCnt-1; i++) {
            for (int j = i + 1; j < universeCnt; j++) {
                if (Arrays.equals(map[i], map[j])) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    public static int[] getRankingMap(int[] arr, List<Integer> nums) {
        int planetSize = nums.size();

        nums.sort(Collections.reverseOrder());
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int ranking = 0;

        for (int i = 0; i < planetSize; i++) {
            if (!hashMap.containsKey(nums.get(i))) {
                hashMap.put(nums.get(i), ranking);
                ranking++;
            }
        }

        int[] rankedMap = new int[planetSize];
        for (int i = 0; i < arr.length; i++) {
            rankedMap[i] = hashMap.get(arr[i]);
        }
        return rankedMap;
    }
}

package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2143_두배열의합 {
    private static ArrayList<Integer> listA = new ArrayList<>();
    private static ArrayList<Integer> listB = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int goal = Integer.parseInt(br.readLine());

        int n =Integer.parseInt(br.readLine());
        int sum[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        put(st, sum, n, listA);

        int m =Integer.parseInt(br.readLine());
        sum = new int[m+1];
        st = new StringTokenizer(br.readLine());
        put(st, sum, m, listB);

        Collections.sort(listB);

        long cnt =0;
        for (int i = 0; i < listA.size(); i++) {
            int tmp = goal - listA.get(i);
            int upperBound = upperBound(listB,tmp);
            int lowerBound = lowerBound(listB, tmp);
            cnt += upperBound - lowerBound;
        }
        System.out.println(cnt);


    }

    private static void put(StringTokenizer st, int[] sum, int m, ArrayList<Integer> list) {
        for (int i = 1; i <= m; i++) {
            int temp = Integer.parseInt(st.nextToken());
            sum[i] = sum[i - 1] + temp;
            for (int j = 0; j < i; j++) {
                list.add(sum[i] - sum[j]);
            }
        }
    }

    /** checking lowerBound  **/
    private static int lowerBound(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start + end) >> 1;
            if (list.get(mid) >= target) end = mid;
            else start = mid + 1;
        }
        return end;
    }

    private static int upperBound(ArrayList<Integer> list, int target) {
        int start = 0;
        int end = list.size();
        while (start < end) {
            int mid = (start + end) >> 1;
            if (list.get(mid) <= target) start = mid + 1;
            else end = mid;
        }
        return end;
    }

}

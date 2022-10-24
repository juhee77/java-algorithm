package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_1208_부분수열의합2_answer {
    private static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        arr = new int[numberCount];
        long cnt = 0;

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < numberCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayList<Integer> list1 = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();

        put(0, numberCount / 2, 0, list1);
        put(numberCount / 2 , numberCount, 0, list2);
        Collections.sort(list2);

        for (int i = 0; i < list1.size(); i++) {
            int tmp = goal - list1.get(i);
            int upperBound = upperBound(list2, tmp);
            int lowerBound = lowerBound(list2, tmp);
            cnt += upperBound - lowerBound;
        }
        System.out.println((goal==0)?cnt-1:cnt);

    }

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

    private static void put(int start, int end, int sum, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        put(start + 1, end, sum + arr[start], list);
        put(start + 1, end, sum, list);
    }


}
/*
10 0
-1 1 -1 1 -1 1 -1 1 -1 1

6 0
-1 1 -1 1 -1 1
 */

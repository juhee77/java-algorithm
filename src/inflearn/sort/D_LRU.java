package inflearn.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class D_LRU {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(s, n, arr));
        System.out.println(Arrays.toString(solution2(s, n, arr)));
    }

    //배열로 하기 ( 코딩 인터뷰 에서 )
    private static String solution(int cashSize, int n, int[] arr) {
        List<Integer> cash = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (cash.contains(arr[i])) {
                cash.remove(cash.indexOf(arr[i]));
            } else if (cash.size() == cashSize) {
                cash.remove(cash.remove(cashSize - 1));
            }
            cash.add(0, arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for (Integer integer : cash) {
            sb.append(integer + " ");
        }
        return sb.toString();
    }


    public static int[] solution2(int size, int n, int[] arr) {
        int[] cache = new int[size];
        for (int x : arr) {
            int pos = -1;
            for (int i = 0; i < size; i++) if (x == cache[i]) pos = i;
            if (pos == -1) {
                for (int i = size - 1; i >= 1; i--) {
                    cache[i] = cache[i - 1];
                }
            } else for (int i = pos; i >= 1; i--) {
                cache[i] = cache[i - 1];
            }
            cache[0] = x;
        }
        return cache;
    }
}

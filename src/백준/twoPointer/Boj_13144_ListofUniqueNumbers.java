package 백준.twoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_13144_ListofUniqueNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0; //10percent error
        int left=0,right = 0;

        boolean[] isVisited = new boolean[100_001];
        while (left <= right && right < n) {
            while (isVisited[arr[right]]) {//그러면 여기까지 왼칸
                isVisited[arr[left++]] = false;
            }

            isVisited[arr[right++]]= true;
            cnt += (right - left);
        }
        System.out.println(cnt);

    }
}

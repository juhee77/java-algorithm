package 백준.가장긴증가부분수열;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_14003_가장긴증가하는부분수열5 {
    private static ArrayList<Integer> LIS = new ArrayList<>();
    private static int[] save;
    private static int[] arr;
    private static int numberCount;
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        numberCount = Integer.parseInt(br.readLine());
        arr = new int[numberCount];
        save = new int[numberCount];
        LIS.add(-1000000001);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (LIS.get(LIS.size() - 1) < arr[i]) {
                LIS.add(arr[i]);
                save[i] = LIS.size() - 1; //각 배열의 위치를 저장함
            } else {
                int start = 0;
                int end = LIS.size() - 1;

                while (start < end) {
                    int mid = (start + end) >> 1;
                    if (LIS.get(mid) >= arr[i]) end = mid;
                    else start = mid + 1;
                }
                LIS.set(start, arr[i]);
                save[i] = start;
            }
        }
        findLISarr();
    }

    private static void findLISarr() {
        int now = LIS.size() - 1;
        Stack<Integer> s = new Stack<>();
        for (int i = numberCount - 1; 0 <= i; i--) {
            if (save[i] == now) {
                s.push(arr[i]);
                now--;
            }
        }
        sb.append(LIS.size() - 1).append("\n");
        while (!s.isEmpty()) sb.append(s.pop()).append(" ");
        System.out.println(sb);
    }
}


//10
//        -61 -28 -72 59 13 -21 84 -76 -52 -1
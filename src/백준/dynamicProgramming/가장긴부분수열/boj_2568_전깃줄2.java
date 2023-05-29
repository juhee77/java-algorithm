package 백준.dynamicProgramming.가장긴부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_2568_전깃줄2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[][] lines = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            lines[i][0] = Integer.parseInt(st.nextToken());
            lines[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(lines, Comparator.comparingInt(o -> o[0]));

        //증가하는 수열의 순으로
        ArrayList<Integer> arr = new ArrayList<>();
        int[] save = new int[n];
        arr.add(-10000000);
        for (int i = 0; i < n; i++) {
            int[] line = lines[i];
            if (arr.get(arr.size() - 1) < line[1]) {
                arr.add(line[1]);
                save[i] = arr.size() - 1;
            }else{
                int start = 0;
                int end = arr.size() - 1;
                while (start < end) { //중간에 찾아서 넣는다.
                    int mid = (start+end)>>1;
                    if(arr.get(mid)>=line[1]) end = mid;
                    else start = mid+1;
                }
                arr.set(start, line[1]);
                save[i] = start;
            }
        }
        sb.append(n-(arr.size() - 1)).append("\n");

        int now = arr.size() - 1;
        Stack<Integer> saveIdx = new Stack<>();
        for (int i = n - 1; 0 <= i; i--) {
            if (save[i] == now) { //사용하는 경우
                now--;
            }else{//사용하지 않는 경우
                saveIdx.push(lines[i][0]);
            }
        }
        while (!saveIdx.isEmpty()) {
            sb.append(saveIdx.pop()).append("\n");
        }
        System.out.println(sb);

    }
}

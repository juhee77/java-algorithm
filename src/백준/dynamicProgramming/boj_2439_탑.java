package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class boj_2439_탑 {
    private static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int topN = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[topN];

        Stack<Integer> s = new Stack<>();
        sb.append("0 ");
        s.add(0);
        s.add(1);
        arr[0] = Integer.parseInt(st.nextToken());

        for (int i = 1; i<topN; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            while(s.peek()!=0&& arr[s.peek()-1] <= arr[i]){
                s.pop();
            }
            sb.append((s.peek()==0)?0:s.peek()).append(" ");
            s.add(i+1);

        }

        System.out.println(sb);
    }

}

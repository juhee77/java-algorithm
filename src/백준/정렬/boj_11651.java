package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_11651 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());

        ArrayList<Integer>[] bucket = new ArrayList[200001];
        for(int i=0;i<200001;i++){
            bucket[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bucket[y+100000].add(x);
        }

        for(int i=0;i<200001;i++){
            Collections.sort(bucket[i]);
            int j=0;
            while(bucket[i].size()>j){
                sb.append(bucket[i].get(j++)).append(" ").append(i-100000).append('\n');
            }
        }
        System.out.println(sb);
    }
}

package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_1269 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        HashSet<Integer> hash = new HashSet<Integer>();
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            int temp= Integer.parseInt(st.nextToken());
            hash.add(temp);
        }

        int cnt1=n;
        int cnt2=m;
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<m;i++){
            int temp= Integer.parseInt(st.nextToken());
            if(hash.contains(temp)){
                cnt1--;
                cnt2--;
            }
        }

        sb.append(cnt1+cnt2);
        System.out.println(sb);
    }
}

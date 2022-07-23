package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_10816_hashmap {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); //상근

        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();
        int m=Integer.parseInt(br.readLine());

        StringTokenizer hashst = new StringTokenizer(br.readLine()); //hash

        for(int i=0;i<m;i++){
            int tmp= Integer.parseInt(hashst.nextToken());
            hash.put(i,tmp);
        }

        int cnt[]=new int[m];
        for(int i=0;i<n;i++){
            int temp=Integer.parseInt(st.nextToken());
            for (int key : hash.keySet()) {
                if (temp==hash.get(key)) {
                    cnt[key]++;
                }
            }

        }

        for(int i=0;i<m;i++)sb.append(cnt[i]+" ");
        System.out.println(sb);

    }
}

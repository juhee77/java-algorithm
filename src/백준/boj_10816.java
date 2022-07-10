package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine()); //상근
        HashMap<Integer,Integer> hash = new HashMap<Integer,Integer>();

        for(int i=0;i<n;i++){
            int tmp= Integer.parseInt(st.nextToken());
            if(hash.containsKey(tmp))
                hash.put(tmp,hash.get(tmp)+1);
            else
                hash.put(tmp,1);
        }


        int m=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int cnt[]=new int[m];
        for(int i=0;i<m;i++){
            int temp=Integer.parseInt(st.nextToken());
            if(hash.containsKey(temp)){
                cnt[i]+=hash.get(temp);
            }
        }

        for(int i=0;i<m;i++)sb.append(cnt[i]+" ");
        System.out.println(sb);

    }
}

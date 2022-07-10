package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_10815_hashtable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        HashSet<Integer> hash = new HashSet<Integer>();

        for(int i=0;i<n;i++){
            hash.add(Integer.parseInt(st.nextToken()));
        }

        n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            if(hash.contains(Integer.parseInt(st.nextToken())))
                sb.append("1 ");
            else
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}

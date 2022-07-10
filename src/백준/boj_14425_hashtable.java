package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Hashtable;
import java.util.StringTokenizer;

public class boj_14425_hashtable {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        Hashtable<String,Integer> hash = new Hashtable<String,Integer>();

        for(int i=0;i<n;i++){
            hash.put(br.readLine(),i);
        }

        int cnt=0;
        for(int i=0;i<m;i++){
            if(hash.containsKey(br.readLine()))
                cnt++;
        }
        System.out.println(cnt);
    }
}

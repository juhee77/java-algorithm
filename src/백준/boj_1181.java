package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class boj_1181 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n=Integer.parseInt(br.readLine());

        ArrayList<String>[] bucket = new ArrayList[51];
        for(int i=0;i<51;i++){
            bucket[i] = new ArrayList<>();
        }

        for(int i=0;i<n;i++){
            String x = br.readLine();
            if(bucket[x.length()].contains(x)) continue;
            else  bucket[x.length()].add(x);
        }

        for(int i=0;i<51;i++){
            Collections.sort(bucket[i]);
            int j=0;
            while(bucket[i].size()>j){
                sb.append(bucket[i].get(j++)).append('\n');
            }
        }
        System.out.println(sb);
    }
}

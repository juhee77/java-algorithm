package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class boj_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n=Integer.parseInt(st.nextToken());
        int m=Integer.parseInt(st.nextToken());

        HashMap<String,Integer> hash = new HashMap<String,Integer>();

        for(int i=0;i<n;i++){
            String temp = br.readLine();
            hash.put(temp,0);
        }

        int cnt=0;
        ArrayList<String> list= new ArrayList<String>();
        for(int i=0;i<m;i++){
            String temp = br.readLine();
            if(hash.containsKey(temp)){
                list.add(temp);
            }
        }

        Collections.sort(list);
        sb.append(list.size()).append('\n');
        for(int i=0;i<list.size();i++)sb.append(list.get(i)+'\n');
        System.out.println(sb);
    }
}

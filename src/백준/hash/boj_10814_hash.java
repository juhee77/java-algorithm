package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10814_hash {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[]= new int[n];
        int cpyarr[]= new int[n];
        HashMap<Integer,Integer> rank = new HashMap<Integer,Integer>();


        for(int i=0;i<n;i++){
            int s = Integer.parseInt(st.nextToken());
            arr[i]=cpyarr[i]=s;
        }

        Arrays.sort(cpyarr);
        int  ranking=0;
        for(int i=0;i<cpyarr.length;i++){
            if(!rank.containsKey(cpyarr[i])){
                rank.put(cpyarr[i],ranking);
                ranking++;
            }
        }

        for(int i:arr){
            int rate = rank.get(i);
            sb.append(rate).append(' ');
        }

        System.out.println(sb);
    }
}

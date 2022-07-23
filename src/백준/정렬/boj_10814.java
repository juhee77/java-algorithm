package 백준.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int n=Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int arr[]= new int[n];
        ArrayList<Integer> sortlist=new ArrayList<Integer>();

        for(int i=0;i<n;i++){
            int s = Integer.parseInt(st.nextToken());
            arr[i]=s;
            if(!sortlist.contains(s))sortlist.add(s);
        }

        Collections.sort(sortlist);
        int ansArr[] = new int[n];


        for(int i=0;i<sortlist.size();i++){
            long temp=sortlist.get(i);
            for (int j = 0; j < n; j++) {
                    if (temp == arr[j]) {
                        arr[j] =  (int)Math.pow(10, 10);
                        ansArr[j] =  i;
                    }
                }
            }

        for(int i:ansArr){
            sb.append(i).append(' ');
        }

        System.out.println(sb);
    }
}

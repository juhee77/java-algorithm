package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_10814 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Long n=Long.parseLong(br.readLine());
        st = new StringTokenizer(br.readLine());
        Long arr[]= new Long[Math.toIntExact(n)];
        ArrayList<Long> sortlist=new ArrayList<Long>();

        for(int i=0;i<n;i++){
            Long s = Long.parseLong(st.nextToken());
            arr[i]=s;
            if(!sortlist.contains(s))sortlist.add(s);
        }

        Collections.sort(sortlist);
        Long ansArr[] = new Long[Math.toIntExact(n)];


        for(int i=0;i<sortlist.size();i++){
            long temp=sortlist.get(i);
            for (int j = 0; j < n; j++) {
                    if (temp == arr[j]) {
                        arr[j] = (long) Math.pow(10, 10);
                        ansArr[j] = (long) i;
                    }
                }
            }

        for(Long i:ansArr){
            sb.append(i).append(' ');
        }
        System.out.println(sb);
    }
}

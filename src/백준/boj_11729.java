package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11729 {
    private static final StringBuilder s = new StringBuilder();
    public static void hanoi(int n, int start,int end, int mid){
        if(n==0)return;
        //if(n==1)System.out.println(start+" "+end);
        hanoi(n - 1, start, mid, end);
        s.append(start).append(" ").append(end).append("\n");
        hanoi(n - 1, mid, end, start);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        System.out.println((int)Math.pow(2,n)-1);
        hanoi(n,1,3,2);
        System.out.println(s);
    }
}

package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int start =665;

        int size = Integer.parseInt(br.readLine());

        while(size>0){ //point 그냥 모두 돌아가버리게
            start++;
            String temp = Integer.toString(start);
            if(temp.contains("666")){ //point
                size--;
                //System.out.println(start);
            }

        }
        System.out.println(start);

    }
}

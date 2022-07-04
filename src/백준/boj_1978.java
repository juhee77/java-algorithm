package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int sum=0;
        st = new StringTokenizer(br.readLine());
        int max=0;

        for(int i=0;i<size;i++){
            int temp=Integer.parseInt(st.nextToken());
        }

        System.out.println(((double) sum/max*100)/size);


    }
}

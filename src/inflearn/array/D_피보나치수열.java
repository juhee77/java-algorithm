package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class D_피보나치수열 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());

        int before= 1;
        int now =1;
        sb.append(before+" "+now+" ");
        for(int i=3;i<line+1;i++){
            sb.append(now+before+" ");

            int temp = now;
            now = now+before;
            before = temp;
        }
        System.out.println(sb);
    }
}

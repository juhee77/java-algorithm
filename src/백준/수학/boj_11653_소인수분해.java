package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11653_소인수분해 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        if (n>1) {
            while (n > 1) {

                for (int i = 2; i <= n; i++) {
                    if(n%i==0){
                        sb.append(i).append("\n");
                        n/=i;
                        break;
                    }
                }
            }
        }
        System.out.println(sb);
    }
}

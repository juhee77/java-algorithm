package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_1541_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String all = br.readLine();
        String[] minusArr = all.split("-");
        int ans =0;

        for (int i = 0; i < minusArr.length; i++) {
            String temp[] = minusArr[i].split("\\+");
            int tempSum=0;
            for(int j=0;j<temp.length;j++) {
                tempSum += Integer.parseInt(temp[j]);
            }
            if(i ==0 )ans += tempSum;
            else ans -= tempSum;
        }

        sb.append(ans);
        System.out.println(sb);
    }
}

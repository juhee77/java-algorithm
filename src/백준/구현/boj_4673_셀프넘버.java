package 백준.구현;

import java.io.IOException;

public class boj_4673_셀프넘버 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();

        boolean[] check = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            if(check[i]) continue;

            int temp = i;
            sb.append(temp).append("\n");
            while (temp <= 10000) {
                int ans = temp;
                check[temp] = true;
                while (0 < ans) {
                    temp += ans%10;
                    ans/=10;
                }
                //System.out.println(temp);
            }
        }
        System.out.println(sb);
    }
}

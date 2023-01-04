package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J_봉우리 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int arr[][] = new int [num+2][num+2];
        for(int i=1;i<=num;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1;j<=num;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans =0;
        for(int i=1;i<=num;i++){
            for(int j=1;j<=num;j++){
                int now = arr[i][j];
                if(arr[i-1][j]<now && arr[i+1][j]<now && arr[i][j-1]<now && arr[i][j+1]<now ) ans++;
            }
        }
        System.out.println(ans);

    }
}

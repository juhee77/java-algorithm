package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class  boj_1051_숫자정사각형 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int map[][] = new int[n][m];
        for(int i=0;i<n;i++){
            char[] temp = br.readLine().toCharArray();
            for(int j=0;j<m;j++){
                map[i][j]=temp[j]-'a';
            }
        }

        int max = 0;
        for(int i=Math.min(n,m);0<i&&max==0;i--){
            //i = boxSize
            for(int p=0;p<=n-i&&max==0;p++){
                for(int q=0;q<=m-i&&max==0;q++){
                    int k = map[p][q];
                    if(map[p+i-1][q]==k&&map[p+i-1][q+i-1]==k&&map[p][q+i-1]==k){
                        max = i;
                    }
                }
            }
        }
        System.out.println(max*max);

    }
}

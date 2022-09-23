package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465_스티커 {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb= new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while(tc-->0){
            int col = Integer.parseInt(br.readLine());
            int map[][] = new int[2][col];
            int map1[] = new int[col]; //OX
            int map2[] = new int[col]; //XO
            int map3[] = new int[col]; //XX
            for(int i=0;i<2;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=0;j<col;j++)map[i][j] = Integer.parseInt(st.nextToken());
            }
            map1[0] = map[0][0];
            map2[0] = map[1][0];
            for(int i=1;i<col;i++){
                map1[i]=Math.max(map3[i-1]+map[0][i],map2[i-1]+map[0][i]);
                map2[i] = Math.max(map3[i-1]+map[1][i],map1[i-1]+map[1][i]);
                map3[i] = Math.max(map3[i-1],Math.max(map1[i-1],map2[i-1]));


                /*
                //ex) ox -> xx 가 되는 경우의 케이스
                int ox_xx = map1[i-1];
                int ox_xo = map1[i-1]+map[1][i];
                int xx_ox = map3[i-1]+map[0][i];
                int xx_xx =map3[i-1];
                int xx_xo = map3[i-1]+map[1][i];
                int xo_xx = map2[i-1];
                int xo_ox = map2[i-1]+map[0][i];

                map1[i]=Math.max(xx_ox,xo_ox);
                map2[i] = Math.max(ox_xo,xx_xo);
                map3[i] = Math.max(Math.max(ox_xx,xx_xx),xo_xx);
                 */
            }
            sb.append(Math.max(Math.max(map1[col-1],map2[col-1]),map3[col-1])+"\n");
        }
        System.out.println(sb);
    }
}

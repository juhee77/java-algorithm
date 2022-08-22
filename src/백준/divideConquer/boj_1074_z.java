package 백준.divideConquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1074_z {
    private static int dc(int rstart, int rend, int cstart, int cend, int row, int col, int n) {
        if (rstart == rend || cstart == cend || n < 1) return 0;
        else {
            //System.out.println(rstart + " " + rend + " " + cstart + " " + cend + " ");
            int rmid = (rstart + rend) / 2; //가로세로를 크게 반씩 잘라 4등분 함
            int cmid = (cstart + cend) / 2;
            if (rmid == rstart || rmid == rend || cmid == cstart || cmid == cend) return 0;
            int cnt = (int) Math.pow(Math.pow(2, n-1),2);
            System.out.println(cnt);
            if (rmid <= row) {
                if (cmid <= col) return cnt * 3  + dc(rmid, rend, cmid, cend, row, col, n - 1); //맨 아래 오른쪽
                else if (cmid > col) return cnt * 2  + dc(rmid, rend, cstart, cmid, row, col, n - 1); // 맨 아래 왼쪽
            }
            else if (row <rmid) {
                if (cmid <=col) return cnt  + dc(rstart, rmid, cmid, cend, row, col, n - 1); //맨 위에 오른쪽
                else if (cmid > col) return dc(rstart, rmid, cstart, cmid, row, col, n - 1); // 맨위에 왼쪽
            }
            return 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int block = (int) Math.pow(2, n);
        //divide conquer
        System.out.println(dc(0, block, 0, block , r, c, n)); //하얀색
    }

}

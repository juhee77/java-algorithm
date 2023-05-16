package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 시간초과
 */
public class boj_1034_램프_bit {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        String[] map = new String[row];

        for (int i = 0; i < row; i++) {
            map[i] = br.readLine();
        }

        int chance = Integer.parseInt(br.readLine());
        int max = 0;

        for (int i = 0; i < row; i++) {
            int offCnt = 0;
            for (int j = 0; j < col; j++) {//가로줄에 켜진것 센다.
                if (map[i].charAt(j) == '0') offCnt++;
            }

            //한줄씩 해당 줄에 불이 들어오는 경우라고 생각
            // 한줄에 불이 들어온경우에는 현재 줄과 같은 경우만 한 줄(행)이 불이 들어온다.
            //해시를 이용하여 비교할 수도 있다.
            int tmpMax = 0;
            if (offCnt <= chance && offCnt % 2 == chance % 2) {
                for (int j = 0; j < row; j++) {
                    if(map[i].equals(map[j])) tmpMax++;
                }
            }

            max = Math.max(tmpMax, max);
        }

        System.out.println(max);
    }
}

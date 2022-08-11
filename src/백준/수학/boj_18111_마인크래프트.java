package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_18111_마인크래프트 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int hold = Integer.parseInt(st.nextToken());
        int[][] arr = new int[row][col];
        int max = 0, min = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < row; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < col; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(arr[i][j], max);
                min = Math.min(arr[i][j], min);
                sum += arr[i][j];
            }
        }
        //높이 제한
        max = (max>256)? 256: max;

        int minTime = Integer.MAX_VALUE;
        int maxHight = -1;
        int block = row * col;
        for (int i = min; i <= max; i++) {
            int temp = i * block;

            /*평지가 이미 고른 갯수인경우 */
            if (sum == temp) {
                int flag = 0;
                for (int r = 0; r < row; r++) for (int c = 0; c < col; c++) if (i != arr[r][c]) flag+= Math.abs(arr[r][c]-i);
                if (flag == 0) {
                    /*이미 평지인 경우*/
                    minTime = 0;
                    maxHight = i;
                    break;
                } else {
                    /*평지가 아닌 한쪽만 올라오고 내려간 경우*/
                    int nowTime = 3 * (flag / 2);
                    if (minTime >= nowTime) {
                        if(minTime==nowTime)maxHight = Math.max(maxHight, i);
                        else maxHight = i;
                        minTime = nowTime;
                    }
                }
            }

            /*추가해야하는경우 *//*제거해야 하는 경우 */
            else {
                int deleteBlock = 0, addBlock = 0;
                for (int r = 0; r < row; r++) {
                    for (int c = 0; c < col; c++) {
                        if (i == arr[r][c]) continue;
                        else if (i < arr[r][c]) deleteBlock += arr[r][c] - i;
                        else if (i > arr[r][c]) addBlock += i - arr[r][c];
                    }
                }

                /*추가해야하는데 블록이 부족한 경우*/
                if ((deleteBlock+hold)<addBlock) continue;

                int nowTime = deleteBlock * 2 + addBlock * 1;
                if (minTime >= nowTime) {
                    if(minTime==nowTime)maxHight = Math.max(maxHight, i);
                    else maxHight = i;
                    minTime = nowTime;
                }

            }
            System.out.println(i + " " + minTime + " " + maxHight);

        }
        sb.append(minTime + " " + maxHight);
        System.out.println(sb);

    }
}

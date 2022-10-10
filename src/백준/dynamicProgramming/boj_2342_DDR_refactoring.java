package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2342_DDR_refactoring {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int arr[][] = new int[5][5];
        int next = Integer.parseInt(st.nextToken());
        if (next == 0) System.out.println(0); //처음 부터 0인 경우 (예외처리)
        else {
            for(int i=0;i<5;i++) Arrays.fill(arr[i],500000); //초기화
            arr[next][0] = arr[0][next] = 2; //초기값 (처음에는 0부터 이동)

            while (st.hasMoreTokens()) {
//                for (int i = 0; i < 5; i++) System.out.println(Arrays.toString(arr[i]));
//                System.out.println();

                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) break; // 끝나면 멈춤

                int temparr[][] = new int[5][5]; //dp 저장용 *3차원 배열으로도 가능*
                for(int i=0;i<5;i++) Arrays.fill(temparr[i],500000);//초기화

                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (arr[i][j] != 500000) //이전에 밟은 적이 있음
                        {
                            int now = arr[i][j]; //현재 밟은 칸
                            int nowr = temparr[temp][j]; //오른발이 옮겨지는 경우 이동칸
                            int nowl = temparr[i][temp]; //왼발이 옮겨지는 경우 이동칸
                            //오른발 이동(함수로 뺄수도 있음)
                            if (temp != j) //양발이 한 칸에 있을수 없음
                                if (i == temp) temparr[temp][j]  = Math.min(nowr,now + 1); //같은칸
                                else if (i == 0) temparr[temp][j] = Math.min(nowr,now + 2); //0에서 이동
                                else if (Math.abs(i % 4 - temp % 4) == 2) temparr[temp][j] = Math.min(nowr,now + 4); //13 24
                                else temparr[temp][j] = Math.min(nowr,now + 3); //나머지 경우
                            //왼발 이동
                            if (temp != i) //양발이 한 칸에 있을수 없음
                                if (j == temp) temparr[i][temp] = Math.min(nowl,now+1);
                                else if (j == 0) temparr[i][temp] = Math.min(nowl,now+2);
                                else if (Math.abs(j % 4 - temp % 4) == 2) temparr[i][temp] = Math.min(nowl,now+4);
                                else temparr[i][temp] = Math.min(nowl,now+3);

                        }
                    }
                }
                for (int i = 0; i < 5; i++) arr[i] = temparr[i].clone(); // temp를 저장한다.(3차원 배열시 없어도 된다)
            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++)
                        min = Math.min(min, arr[i][j]);
            System.out.println(min);
        }


    }
}


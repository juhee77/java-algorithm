package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2342_DDR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = 0, r = 0;
        int arr[][] = new int[5][5];
        int next = Integer.parseInt(st.nextToken());
        if (next == 0) System.out.println(0);
        else {
            arr[next][0] = arr[0][next] = 2;

            while (st.hasMoreTokens()) {
                for (int i = 0; i < 5; i++) System.out.println(Arrays.toString(arr[i]));
                System.out.println();

                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) break;
                int temparr[][] = new int[5][5];
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (arr[i][j] != 0) //이전에 밟은 적이 있음
                        {

                            int now = arr[i][j];
                            int nowr = temparr[temp][j];
                            int nowl = temparr[i][temp];
                            //오른발 이동
                            if (temp != j)
                                if (i == temp) temparr[temp][j]  = (nowr==0)?now + 1:Math.min(nowr,now + 1);
                                else if (i == 0) temparr[temp][j] = (nowr==0)?now + 2:Math.min(nowr,now + 2);
                                else if (Math.abs(i % 4 - temp % 4) == 2) temparr[temp][j] = (nowr==0)?now + 4:Math.min(nowr,now + 4);
                                else temparr[temp][j] = (nowr==0)?now + 3:Math.min(nowr,now + 3);
                            //왼발 이동
                            if (temp != i)
                                if (j == temp) temparr[i][temp] = (nowl==0)?now+1:Math.min(nowl,now+1);
                                else if (j == 0) temparr[i][temp] = (nowl==0)?now+2:Math.min(nowl,now+2);
                                else if (Math.abs(j % 4 - temp % 4) == 2) temparr[i][temp] = (nowl==0)?now+4:Math.min(nowl,now+4);
                                else temparr[i][temp] = (nowl==0)?now+3:Math.min(nowl,now+3);

                        }
                    }
                }

                for (int i = 0; i < 5; i++) arr[i] = temparr[i].clone();

            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++)
                    if (arr[i][j] != 0)
                        min = Math.min(min, arr[i][j]);
            System.out.println(min);
        }


    }
}

/*
package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2342_DDR {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int l = 0, r = 0;
        int arr[][] = new int[5][5];
        int next = Integer.parseInt(st.nextToken());
        if (next == 0) System.out.println(0);
        else {
            for(int i=0;i<5;i++) Arrays.fill(arr[i],500000);
            arr[next][0] = arr[0][next] = 2;

            while (st.hasMoreTokens()) {
                for (int i = 0; i < 5; i++) System.out.println(Arrays.toString(arr[i]));
                System.out.println();

                int temp = Integer.parseInt(st.nextToken());
                if (temp == 0) break;
                int temparr[][] = new int[5][5];
                for(int i=0;i<5;i++) Arrays.fill(temparr[i],500000);
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (arr[i][j] != 500000) //이전에 밟은 적이 있음
                        {

                            int now = arr[i][j];
                            int nowr = temparr[temp][j];
                            int nowl = temparr[i][temp];
                            //오른발 이동
                            if (temp != j) //양발이 한 칸에 있을수 없음
                                if (i == temp) temparr[temp][j]  = Math.min(nowr,now + 1);
                                else if (i == 0) temparr[temp][j] = Math.min(nowr,now + 2);
                                else if (Math.abs(i % 4 - temp % 4) == 2) temparr[temp][j] = Math.min(nowr,now + 4); //13 24
                                else temparr[temp][j] = Math.min(nowr,now + 3);
                            //왼발 이동
                            if (temp != i)
                                if (j == temp) temparr[i][temp] = Math.min(nowl,now+1);
                                else if (j == 0) temparr[i][temp] = Math.min(nowl,now+2);
                                else if (Math.abs(j % 4 - temp % 4) == 2) temparr[i][temp] = Math.min(nowl,now+4);
                                else temparr[i][temp] = Math.min(nowl,now+3);

                        }
                    }
                }
                for (int i = 0; i < 5; i++) arr[i] = temparr[i].clone();

            }

            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 5; i++)
                for (int j = 0; j < 5; j++)
                        min = Math.min(min, arr[i][j]);
            System.out.println(min);
        }


    }
}

 */
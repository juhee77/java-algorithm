package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        //금메달 수
        //금매달 수 같으면 은메달 수
        //둘달 같은면 동메달
        //어느 국가가 몇등인지 알려주는 프로그램

        st = new StringTokenizer(br.readLine());
        int city = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken())-1;


        int[][] arr = new int[city][4];
        for (int i = 0; i < city; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken())-1;
            arr[index][0] = Integer.parseInt(st.nextToken());
            arr[index][1] = Integer.parseInt(st.nextToken());
            arr[index][2] = Integer.parseInt(st.nextToken());
        }

        int rank=1;
        int[] myCountry = arr[target];
        for (int i = 0; i < city; i++) {
            if(i==target) continue;
            int[] nowCountry = arr[i];
            if(nowCountry[0] > myCountry[0]) {
                rank++;
            } else if (nowCountry[0] == myCountry[0]) {
                if (nowCountry[1] > myCountry[1]) {
                    rank++;
                } else if (nowCountry[1] == myCountry[1]) {
                    if (nowCountry[2] > myCountry[2]) {
                        rank++;
                    }
                }
            }
        }

        System.out.println(rank);
    }

}

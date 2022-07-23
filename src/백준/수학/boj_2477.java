package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_2477 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int m2per = Integer.parseInt(br.readLine());

        int maxX = 0, minX = 501, maxY = 0, minY = 501;
        int arr[] = new int[5];
        int save[][] = new int[6][2];
        int duplicate1 = 0, duplicate2 = 0;

        for (int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int dir = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            save[i][0] = dir;
            save[i][1] = distance;

            if (dir == 1 || dir == 2) maxX = Math.max(maxX, distance);
            else if (dir == 3 || dir == 4) maxY = Math.max(maxY, distance);

            arr[dir]++;
            if (arr[dir] == 2 && duplicate1 == 0) duplicate1 = dir;
            else if (arr[dir] == 2 && duplicate2 == 0) duplicate2 = dir;

        }

        if (duplicate1 + duplicate2 == 4) {
            for (int i = 0; i < 12; i++) {
                if (save[i % 6][0] == 1 && save[(i+1) % 6][0] == 3) {
                    minX = save[i % 6][1];
                    minY = save[(i+1) % 6][1];
                    break;
                }
            }
        }
        else if (duplicate1 + duplicate2 == 6) {
            for (int i = 0; i < 12; i++) {
                if (save[i % 6][0] == 2 && save[(i+1) % 6][0] == 4) {
                    minX = save[i % 6][1];
                    minY = save[(i+1) % 6][1];
                    break;
                }
            }

        }
        else {
            if (duplicate1 == 2 && duplicate2 == 3 || duplicate1 == 3 && duplicate2 == 2) {
                for (int i = 0; i < 12; i++) {
                    if (save[i % 6][0] == 3 && save[(i+1) % 6][0] == 2) {
                        minX = save[i % 6][1];
                        minY = save[(i+1) % 6][1];
                        break;
                    }
                }
            } else {
                for (int i = 0; i < 12; i++) {
                    if (save[i % 6][0] == 4 && save[(i+1) % 6][0] == 1) {
                        minX = save[i % 6][1];
                        minY = save[(i+1) % 6][1];
                        break;
                    }
                }
            }
        }

        //System.out.println(duplicate1+"  "+duplicate2);
        //System.out.printf("%d  %d  %d  %d\n",maxX,maxY,minX,minY);
        int all = maxX * maxY - minX * minY;
        System.out.println(all * m2per);
    }
}

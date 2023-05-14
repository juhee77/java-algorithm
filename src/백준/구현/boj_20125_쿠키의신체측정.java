package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_20125_쿠키의신체측정 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int size = Integer.parseInt(br.readLine());


        int head = -1;
        int leftArm = 0, rightArm = 0, body = 0, leftLeg = 0, rightLeg = 0;
        char[] temp;

        //머리
        int i = 0;
        Head:
        for (; i < size; i++) {
            temp = br.readLine().toCharArray();

            for (int j = 0; j < size; j++) {
                if (temp[j] == '*') {
                    head = j;
                    sb.append(((++i) + 1)).append(" ").append(j + 1).append("\n");
                    break Head;
                }
            }
        }

        //arm
        temp = br.readLine().toCharArray();
        for (int j = 0; j < size; j++) {
            if (temp[j] == '*') {
                if (j < head) {
                    leftArm++;
                } else if (j > head) {
                    rightArm++;
                }
            }
        }
        i++;

        //body
        for (; i < size; i++) {
            temp = br.readLine().toCharArray();
            if (temp[head] != '*') {
                break;
            }
            body++;
        }

        //leg
        for (; i < size; i++) {
            boolean find = false;
            if (temp[head - 1] == '*' || temp[head + 1] == '*') {
                find = true;
                if(temp[head-1]=='*')leftLeg++;
                else rightLeg++;
            }
            
            if(!find) break;
            if (i != size - 1) temp = br.readLine().toCharArray();
        }

        sb.append(leftArm).append(" ").append(rightArm).append(" ").append(body).append(" ").append(leftLeg).append(" ").append(rightLeg);
        System.out.println(sb);
    }
}


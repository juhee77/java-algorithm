package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_22862_가장긴짝수연속한부분수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int size = Integer.parseInt(st.nextToken());
        int removeCount = Integer.parseInt(st.nextToken());
        int[] oddNumSum = new int[size + 1];

        st = new StringTokenizer(br.readLine());
        int left = 0; //왼쪽 포인터
        int maxLen = 0; //짝수 수열중 가장 긴 길이

        for (int i = 1; i <= size; i++) { //현재 확인하는 범위는 left ~ i 까지 (i 가 right 인덱스의 역할을 한다)
            oddNumSum[i] = oddNumSum[i - 1];

            if (Integer.parseInt(st.nextToken()) % 2 == 1) {
                oddNumSum[i]++; //홀수인 경우 체크한다(삭제대상)
            }

            while (oddNumSum[i] - oddNumSum[left] > removeCount) {
                //현재 가능한 삭제 범위의 개수보다 크면 왼쪽인덱스를 움직인다.
                left++;
            }

            maxLen = Math.max(maxLen, i - left - (oddNumSum[i] - oddNumSum[left]));
            // 값을 갱신한다. 현재까지의 범위 - 제거 가능한 홀수의 개수
        }
        System.out.println(maxLen);

    }
}

package 백준.구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_23970_버블정렬3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] arrStart = new int[n];
        int[] arrEnd = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrStart[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arrEnd[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(contain(n, arrStart, arrEnd) ? 1 : 0);

    }

    private static boolean contain(int n, int[] arrStart, int[] arrEnd) {
        int startIdx = -1, endIdx = -1;
        for (int i = 0; i < n; i++) {
            if (arrStart[i] != arrEnd[i]) {
                if (startIdx == -1) startIdx = i; // 처음 차이나는 위치 저장
                endIdx = i; // 마지막 차이나는 위치 갱신
            }
        }
//        System.out.println(startIdx + " " + endIdx);
        if (startIdx == -1) return true;
        return bubbleSortCheck(arrStart, arrEnd, startIdx, endIdx);
    }

    private static boolean bubbleSortCheck(int[] arr, int[] arrEnd, int start, int end) {
        // 버블 정렬을 진행하면서 `arrEnd`와 같아질 수 있는지 확인
        for (int i = end; i > start; i--) {
            boolean swapped = false;
            for (int j = start; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap 수행
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;

                    // 중간 상태가 arrEnd와 일치하는지 검사
                    if (isSame(arr, arrEnd)) return true;
                }
            }
            if (!swapped) break; // 이미 정렬 완료된 경우
        }
        return false;
    }

    private static boolean isSame(int[] arrStart, int[] arrEnd) {
        for (int i = 0; i < arrStart.length; i++) {
            if (arrStart[i] != arrEnd[i]) {
                return false;
            }
        }
        return true;
    }
}

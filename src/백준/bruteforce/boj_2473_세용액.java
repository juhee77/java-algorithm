package 백준.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class boj_2473_세용액 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long arr[] = new long[num];

        for (int i = 0; i < num; i++) arr[i] = Long.parseLong(st.nextToken());
        Arrays.sort(arr); // 투포인터 사용하기 위해서 정렬

        long min = Math.abs(arr[0] + arr[1] + arr[2]);
        ArrayList<Long> minArr = new ArrayList(Arrays.asList(arr[0], arr[1], arr[2]));
        //ArrayList<Integer> temp = new ArrayList<>();

        for (int i = 0; i < num; i++) {

            int point = i;
            int left = 0, right = num - 1;

            while (left < right && right < num) {
                if (left == point || right == point) {
                    if (right == point) right--;
                    else left++;
                    continue;
                }
                long temp = arr[point] + arr[right] + arr[left];

                if (Math.abs(temp) < min) {
                    min = Math.abs(temp);
                    minArr = new ArrayList(Arrays.asList(arr[point], arr[left], arr[right]));
                    //System.out.println(point+" "+minArr.get(0)+" "+minArr.get(1)+" "+minArr.get(2));
                }

                if (temp < 0) left++;
                else right--;

            }
        }

        Collections.sort(minArr);
        System.out.println(minArr.get(0) + " " + minArr.get(1) + " " + minArr.get(2));


    }
}

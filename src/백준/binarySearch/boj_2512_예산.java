package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2512_예산 {
    private static int budget;
    private static int[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int city = Integer.parseInt(br.readLine());
        cities = new int[city];
        st = new StringTokenizer(br.readLine());
        int max = 0;

        for (int i = 0; i < city; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, cities[i]);
        }

        budget = Integer.parseInt(br.readLine());

        System.out.println(findBudget(0, max));
    }

    private static int findBudget(int start, int end) {
        if (start > end) return end;

        int mid = (start + end) >> 1;
        int tempSum = calculate(mid);
//        System.out.println(mid+" "+tempSum);
        if (tempSum < budget) return findBudget(mid+1,end);
        else if(tempSum==budget) return mid;
        else return findBudget(start,mid-1);
    }

    private static int calculate(int mid) {
        int sum = 0;
        for (int e : cities) {
            sum += Math.min(e, mid);
        }
        return sum;
    }
}
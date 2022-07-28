package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1037_약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[line+1];
        arr[0]=1;

        for(int i = 1; i <= line ; i++)
            arr[i] =Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int goal =0;
        if(line ==1)goal = arr[line]*arr[line];
        else goal = arr[1]*arr[line];
        System.out.println(goal);

    }
}

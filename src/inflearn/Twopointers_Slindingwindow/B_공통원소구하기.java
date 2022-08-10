package inflearn.Twopointers_Slindingwindow;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class B_공통원소구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int num = Integer.parseInt(br.readLine());
        int arr[] = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        int num2 = Integer.parseInt(br.readLine());
        int arr2[] = Arrays.stream(br.readLine().split(" ")).mapToInt(i -> Integer.parseInt(i)).toArray();

        ArrayList<Integer> ans = new ArrayList<>();
        Arrays.sort(arr);
        Arrays.sort(arr2);
        int p = 0, q = 0;
        while (true) {
            if (arr[p] == arr2[q])
                ans.add(arr[p]);

            if (arr[p] > arr2[q]) q++;
            else p++;

            if(p>=arr.length || q>=arr2.length) break;


        }
        for(int e: ans) sb.append(e+" ");
        System.out.println(sb);

    }
}

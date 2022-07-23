package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_11047_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int line = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        int arr[] =new int[line];

        for(int i=0;i<line;i++){
            arr[i]=Integer.parseInt(br.readLine());
        }

        int goalArr[] = new int[goal+1];

        for(int i=0;i<goal+1;i++){
            goalArr[i]= i/1;
            for(int j=1;j<line;j++){
                if(goalArr[i%arr[j]]!=0||i%arr[j]==0)
                    goalArr[i] = Math.min(goalArr[i],(int)i/arr[j]+goalArr[i%arr[j]]);
            }
        }
        //System.out.println(Arrays.toString(goalArr));
        sb.append(goalArr[goal]);
        System.out.println(sb);
    }
}

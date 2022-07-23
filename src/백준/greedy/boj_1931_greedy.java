package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class boj_1931_greedy {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb=new StringBuilder();

        int line = Integer.parseInt(br.readLine());
        int arr[][] = new int[line][2];

        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            arr[i][0]=start;
            arr[i][1]=end;
        }

        //2차원 배열 정렬 방법 (뒷자리 기준 오름 차순 내림차순인경우 o2-o1으로 변경)
        Arrays.sort(arr,new Comparator<int[]>(){
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1])return o1[0]-o2[0];
                else return o1[1]-o2[1];
            }
        });

        int start = arr[0][0];
        int end = arr[0][1];
        int ans=1;

        //정렬 확인용
        //for(int i=0;i<line;i++) System.out.println(Arrays.toString(arr[i]));

        for(int i=1;i<line;i++){
            start = arr[i][0];
            if(end<=start) {
                ans++;
                end = arr[i][1];
            }
        }

        //System.out.println(Arrays.toString(goalArr));
        sb.append(ans);
        System.out.println(sb);
    }
}

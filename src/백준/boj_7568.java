package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_7568 {
    public static int compare(int arr[][],int i,int j){
        if(arr[i][0]<arr[j][0] && arr[i][1]<arr[j][1]) return 1;
        else return 0;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int arr[][] = new int[size][2];

        for(int i=0;i<size;i++){
            st = new StringTokenizer(br.readLine());

            int weight= Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            arr[i][0]=weight;
            arr[i][1]=height;

        }

        int ans[] = new int[size];

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(i==j) continue;
                ans[i]+=compare(arr,i,j);
            }
            System.out.print(ans[i]+1+" ");
        }
    /* 순위 구하는 건줄
        int rank[] = new int[size];
        for(int i=0;i<size;i++){
            rank[i]=1;
            for(int j=0;j<size;j++){
                if(i==j)continue;
                if(ans[i]>ans[j]) rank[i]++;
            }

        }
        System.out.println(Arrays.toString(ans));
        System.out.println(Arrays.toString(rank));
        */

    }
}


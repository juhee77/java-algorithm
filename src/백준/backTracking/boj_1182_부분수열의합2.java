package 백준.backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_1182_부분수열의합2 {
    static StringBuilder sb = new StringBuilder();
    static int[] num;
    static int[] arr;

    static int cnt =0;
    static int goal;

    private static void dfs(int d, int s) { //s start d depth
        if( 1<=d && d<= num.length ) {
            int sum =0;
            for(int i=0;i<num.length;i++){
                sum += arr[i];
            }
            if(sum==goal) {
                //System.out.println(Arrays.toString(arr));
                cnt++;
            }
        }

        for(int i = s; i < num.length; i++) {
            arr[i] = num[i];
            dfs(d+1,i+1);
            arr[i]=0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int numberCount = Integer.parseInt(st.nextToken());
        goal = Integer.parseInt(st.nextToken());
        HashSet<Integer> hash = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        arr=new int[numberCount];
        num=new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            num[i] =Integer.parseInt(st.nextToken());
        }

        dfs(0,0);

        System.out.println(cnt);

    }
}

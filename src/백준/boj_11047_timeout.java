package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11047_timeout {
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

        int ans=0;
        for(int i=line-1;i>=0;i--){
            if(goal<arr[i]) continue;
            else{
                ans= ans+ (int)goal/arr[i];
                goal=goal-((int)goal/arr[i])*arr[i];
            }

        }
        //System.out.println(Arrays.toString(goalArr));
        sb.append(ans);
        System.out.println(sb);
    }
}

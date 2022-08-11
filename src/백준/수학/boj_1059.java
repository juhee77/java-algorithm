package 백준.수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj_1059 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int arr[] = new int[x];
        for(int i=0;i<x;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int goal = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int left=0,right=0;
        int flag = 1;
        while(left<x){
            if(arr[left]==goal) {
                flag = 0;
                break;
            }
            if(arr[left]<goal) left++;
            else if(arr[left]>goal){
                right=left;
                left= left -1;
                break;
            }
        }

        if(flag == 0 ) { // goal 이 목표 값에 있는 경우
            System.out.println(0);
        }
        else{
            int r = arr[right]-1;
            int l = (left==-1)?1:arr[left]+1;
            //System.out.println(l+" "+r);
            //int sum=0;
            //for(int i=l;i<=goal;i++){
            //    sum+= r-i;
            //    System.out.println(i + " " +(r-i));
            //}
            //System.out.println(sum);
            System.out.println((goal-l)*(r-goal+1)+(r-goal));
            //33 , 59 , 100인 경우 (33,57)이런거는 빼고 계산해야함 (..ㅎ..)
        }

    }
}

package 백준.dynamicProgramming.가장긴증가부분수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class boj_12015_가장긴증가하는부분수열2 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;


        int numberCount = Integer.parseInt(br.readLine());
        int[] arr = new int[numberCount];
        Stack<Integer> LIS = new Stack<>();
        LIS.add(0);

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < numberCount; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(LIS.peek()<arr[i]) LIS.add(arr[i]);
            else{
                //System.out.println(Arrays.toString(LIS.toArray()));
                int start = 0;
                int end = LIS.size()-1;

                while(start<end){
                    int mid = (start+end)/2;//(start+end)>>1;
                    if(LIS.get(mid)>=arr[i]) end = mid;
                    else start = mid+1;
                }
                LIS.set(start,arr[i]);
            }
        }

        System.out.println(LIS.size()-1);


//list 형식이 시간이 더 적게 든다 메모리는 리스트가 더 많이 듬

    }
}

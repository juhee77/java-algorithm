package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj_10989_RadixSort {
    public static void radixSort(int n, Long arr[],int len){
        int now =1;
        Queue<Long>[] bucket = new LinkedList[10];
        for(int i=0;i<10;i++){
            bucket[i] = new LinkedList<>();
        }

        for(int k=0;k<n;k++){
            for(Long i : arr){
                bucket[(int) ((i/now)%10)].add(i);
            }
            for(int i=0,j=0;i<10;i++){
                while(!bucket[i].isEmpty()){
                    arr[j++] = bucket[i].poll();
                }
            }
            now *=10;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        ///int n = Integer.parseInt(br.readLine());
        //st = new StringTokenizer(br.readLine());
        //int n = Integer.parseInt(st.nextToken());
        int n=Integer.parseInt(br.readLine());

        Long arr[] =new Long[n];
        long max=0;

        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(br.readLine());
            max=(max<=arr[i])? arr[i]:max;
        }

        int len = (int) (Math.log10(max)+1);
        //000인 경우는 안됨 else 0 처리 해야함

        radixSort(n,arr,len);
        for(int i=0;i<n;i++){
            System.out.println(arr[i]);
        }
    }
}

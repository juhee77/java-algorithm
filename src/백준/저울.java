package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 저울 {

    static void findMin(int row,int max,int arr[][], int size){
        for(int i=1;i<size+1;i++){
            if(arr[row][i]==row) {// 비교했을때 큰게 row인 경우
                arr[max][i] = arr[i][max] = max;
                findMin(i,max,arr,size);
            }
        }
    }

    static void findMax(int min,int row,int arr[][], int size){
        for(int i=1;i<size+1;i++){
            if(arr[row][i]!=row && arr[row][i]!=0) {// 지금의 max보다 큰 다른 수 인경
                arr[min][i] = arr[i][min] = arr[row][i];
                findMin(i,arr[row][i],arr,size); //과거의 수정사항 재 수정
                findMax(min,i,arr,size);
            }
        }
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int size = Integer.parseInt(br.readLine());
        int arr[][] = new int[size+1][size+1];


        int line = Integer.parseInt(br.readLine());
        for(int i=0;i<line;i++){
            st = new StringTokenizer(br.readLine());

            int min = Integer.parseInt(st.nextToken());
            int max = Integer.parseInt(st.nextToken());
            findMin(min,max,arr,size);
            findMax(min,max,arr,size);
            arr[max][min]=arr[min][max]=max;

            /*System.out.println();
            for(int p=0;p<size+1;p++){
                System.out.println(Arrays.toString(arr[p]));
            }
            System.out.println();
*/
        }

        for(int i=1;i<size+1;i++){
            int cnt=size-1; // 대각선 부분 제외
            for(int j=1;j<=size;j++)if(arr[i][j]!=0)cnt--;
            System.out.println(cnt);
        }
    }
}

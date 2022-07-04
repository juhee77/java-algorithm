package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 저울_Floid {
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

            arr[min][max]=1;
            arr[max][min]=-1;

        }

        for(int k=1;k<size+1;k++){
            for(int i=1;i<size+1;i++){
                for(int j=1;j<=size;j++){
                    if(arr[i][k]==1 && arr[k][j]==1){
                        arr[i][j]=1;
                        arr[j][i]=-1;
                    }
                    if(arr[i][k]==-1&&arr[k][j]==-1){
                        arr[i][j]=-1;
                        arr[j][i]=1;
                    }
                }
            }
        }

        for(int i=1;i<size+1;i++){
            int cnt=-1; //대각선 제외
            for(int j=1;j<size+1;j++){
                if(arr[i][j]==0) cnt++;
            }
            System.out.println(cnt);
        }
    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class sw_1_o
{
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T;
        T=Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int sz=Integer.parseInt(br.readLine());
            int arr[][]=new int[sz+2][sz+2];
            int max=0;


            for(int i=1;i<sz+1;i++){
                st=new StringTokenizer(br.readLine());
                for(int j=1;j<sz+1;j++){
                    if(j==0)arr[i][j]=101;
                    else{
                        arr[i][j]=Integer.parseInt(st.nextToken());
                        if(max<arr[i][j]) max=arr[i][j];
                    }
                }
            }

            int landMax=1;
            //시작 1 끝은 어차피 0
            for(int i=1;i<max;i++) {
                int tempLand = 0;
                for (int c = 0; c < 4; c++) {
                    for (int p = 1; p < sz + 1; p++) {
                        for (int q = 1; q < sz + 1; q++) {
                            if (arr[p][q] <= i) continue;
                            if (arr[p][q - 1] <= i && arr[p - 1][q] <= i) tempLand++;
                        }
                    }
                    int tempLand_2 = 0;
                    for (int p = 1; p < sz + 1; p++) {
                        for (int q = sz; 0 < q; q--) {
                            if (arr[p][q] <= i) continue;
                            if (arr[p][q + 1] <= i && arr[p + 1][q] <= i) tempLand_2++;
                        }
                    }
                    int landMin = Math.min(tempLand, tempLand_2);

                    tempLand = 0;
                    for (int p = sz; 0 < p; p--) {
                        for (int q = 1; q < sz + 1; q++) {
                            if (arr[p][q] <= i) continue;
                            if (arr[p][q - 1] <= i && arr[p + 1][q] <= i) tempLand++;
                        }
                    }
                    landMin = Math.min(tempLand, landMin);

                    tempLand_2 = 0;
                    for (int p = sz; 0 < p; p--) {
                        for (int q = sz; 0 < q; q--) {
                            if (arr[p][q] <= i) continue;
                            if (arr[p][q + 1] <= i && arr[p + 1][q] <= i) tempLand_2++;
                        }
                    }

                    landMax = Math.max(landMax, landMin);
                }
            }


            System.out.println("#"+test_case+" "+landMax);

        }
    }
}


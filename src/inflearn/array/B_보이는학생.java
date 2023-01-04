package inflearn.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_보이는학생 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int line = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = Integer.parseInt(st.nextToken());
        int cnt =1;

        for(int i=1;i<line;i++){
            int temp = Integer.parseInt(st.nextToken());
            if(temp>max) {
                cnt++;
                max= temp;
            }
        }
        System.out.println(cnt);
    }
}

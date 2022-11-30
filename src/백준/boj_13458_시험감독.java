package 백준;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_13458_시험감독 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int classNum = Integer.parseInt(br.readLine());
        long ans = 0;
        List<Integer> allClass = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        while (classNum-- > 0) {
            allClass.add(Integer.parseInt(st.nextToken()));
        }
         st = new StringTokenizer(br.readLine());
        int mainDirector = Integer.parseInt(st.nextToken());
        int assistantDirector = Integer.parseInt(st.nextToken());

        for (int studentNum : allClass) {
            ans+=1; //주감독이 커버 가능함
            if(studentNum>mainDirector) {
                studentNum-= mainDirector;
                ans += Math.ceil((double)studentNum/assistantDirector);
            }
        }
        System.out.println(ans);
    }
}

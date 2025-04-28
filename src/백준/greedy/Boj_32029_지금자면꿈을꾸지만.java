package 백준.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_32029_지금자면꿈을꾸지만 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> deadlines = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            deadlines.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(deadlines);

        int answer = 0;

        // 0번 과제부터 n개까지 중 언제 잠잘지 결정
        for (int sleepPoint = 0; sleepPoint <= n; sleepPoint++) {
            int time = (sleepPoint!=0)?a:0;
            int cnt = 0;

            // sleepPoint 이전까지는 그냥 a 주기로 과제
            for (int i = 0; i < sleepPoint; i++) {
                if (time <= deadlines.get(i)) {
                    cnt++;
                    time += a;
                }
            }
            if(sleepPoint!=0)time-=a;

            // 이제 sleepPoint 시점에 잠잘 수 있음
            for (int x = 0; x < a; x++) {
                int period = a - x;
                //잠을 잔다.
                int curTime = time + x * b + period;
//                System.out.println(time+" "+x+" "+curTime);
                int tempCnt = cnt;

                // sleepPoint부터 나머지 과제 진행
                for (int i = sleepPoint; i < n; i++) {
                    if (curTime <= deadlines.get(i)) {
                        tempCnt++;
                        curTime += period;
                    }
                }

//                System.out.println(sleepPoint+" "+period+" "+cnt+" " +tempCnt);
                answer = Math.max(answer, tempCnt);
            }
        }

        // 잠을 아예 안 자는 경우도 체크
        int time = a;
        int cnt = 0;
        for (int d : deadlines) {
            if (time <= d) {
                cnt++;
                time += a;
            }
        }
//        System.out.println(answer + " " + cnt);
        answer = Math.max(answer, cnt);

        System.out.println(answer);
    }
}

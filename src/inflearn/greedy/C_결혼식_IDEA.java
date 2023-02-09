package inflearn.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C_결혼식_IDEA {
    private static class Status implements Comparable<Status> {
        int time;
        char state;

        public Status(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Status other) {
            if(this.time == other.time) return this.state-other.state;
            //같은것이 있으면(e인 사람은 지금 없는것이므로 빼고 가야한다) e가 먼저, s 가 나중이도록
            return this.time - other.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int x = Integer.parseInt(br.readLine());
        List<Status> arr = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            arr.add(new Status(Integer.parseInt(st.nextToken()), 's'));
            arr.add(new Status(Integer.parseInt(st.nextToken()), 'e'));
        }

        Collections.sort(arr);

        int max = 0;
        int cnt = 0; //현재 피로연에 있는 사람수
        for (Status status : arr) {
            if (status.state == 's') {
                cnt++;
            }
            else{
                cnt--;
            }
            max = Math.max(cnt, max);
        }
        System.out.println(max);
    }
}

package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_3226_전화요금 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int totalFee = 0;

        for (int i = 0; i < N; i++) {
            StringTokenizer st  = new StringTokenizer(br.readLine());
            String timeStr = st.nextToken();
            int duration = Integer.parseInt(st.nextToken());

            String[] timeParts = timeStr.split(":");
            int hour = Integer.parseInt(timeParts[0]);
            int minute = Integer.parseInt(timeParts[1]);

            for (int j = 0; j < duration; j++) {
                if (hour >= 7 && hour < 19) {
                    totalFee += 10;
                } else {
                    totalFee += 5;
                }

                minute++;
                if (minute == 60) {
                    minute = 0;
                    hour++;
                    if (hour == 24) {
                        hour = 0;
                    }
                }
            }
        }
        System.out.println(totalFee);
    }
}

package 백준.binarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 포인트는 공백이 가장 긴것을 고르는것임
 */
public class Boj_2212_센서 {
    private static List<Integer> sensors = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int sensorCnt = Integer.parseInt(br.readLine());
        int ableCenter = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < sensorCnt; i++)
            sensors.add(Integer.parseInt(st.nextToken()));

        Collections.sort(sensors);
        List<Integer> temp = new ArrayList<>();
        for (int i = 1; i < sensorCnt; i++)
            temp.add(sensors.get(i) - sensors.get(i - 1));
        temp.sort(Collections.reverseOrder());


        int ans = sensors.get(sensorCnt - 1) - sensors.get(0);
        int min = Math.min(temp.size(), ableCenter - 1);
        for (int i = 0; i < min; i++)
            ans -= temp.get(i);

        System.out.println(ans);
    }
}

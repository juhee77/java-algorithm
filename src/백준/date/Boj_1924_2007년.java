package 백준.date;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Date;
import java.util.StringTokenizer;

public class Boj_1924_2007년 {
    private static String[] weeks = new String[]{"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());
        Date date = new Date(2007, month - 1, day - 1);
        System.out.println(weeks[date.getDay()]);

    }
}

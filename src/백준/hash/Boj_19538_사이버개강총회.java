package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_19538_사이버개강총회 {
    //동일 사람이 그냥 여러번 채팅을 남길 수도 있다
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        HashSet<String> entry = new HashSet<>();
        HashSet<String> exit = new HashSet<>();
        st = new StringTokenizer(br.readLine());
        int s = getTime(st.nextToken());
        int e = getTime(st.nextToken());
        int se = getTime(st.nextToken());

        String temp;
        int cnt = 0;
        while ((temp = br.readLine())!=null) {
            String[] splited = temp.split(" ");
            int time = getTime(splited[0]);
            String name = splited[1];
            if (time <= s) {//출석
                entry.add(name);
            } else if (e <= time && time <= se) { //퇴실
                exit.add(name);
            }
        }

        for (String name : entry) {
            if (exit.contains(name)) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static int getTime(String times) {
        String[] time = times.split(":");
        int hour = Integer.parseInt(time[0]);
        int min = Integer.parseInt(time[1]);
        return hour * 60 + min;
    }
}

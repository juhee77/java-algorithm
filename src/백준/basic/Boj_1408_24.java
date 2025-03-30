package 백준.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Boj_1408_24 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        LocalTime now = LocalTime.parse(br.readLine(), formatter);
        LocalTime mission = LocalTime.parse(br.readLine(), formatter);

        int nowSeconds = now.toSecondOfDay();
        int missionSeconds = mission.toSecondOfDay();

        if (nowSeconds > missionSeconds) {
            missionSeconds += 24 * 3600;
        }

        int remainingSeconds = missionSeconds - nowSeconds;

        int hours = remainingSeconds / 3600;
        int minutes = (remainingSeconds % 3600) / 60;
        int seconds = remainingSeconds % 60;

        System.out.printf("%02d:%02d:%02d\n", hours, minutes, seconds);
    }
}

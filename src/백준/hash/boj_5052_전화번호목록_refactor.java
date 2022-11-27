package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class boj_5052_전화번호목록_refactor {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int line = Integer.parseInt(br.readLine());
            List<String> number = new ArrayList<>();
            for (int i = 0; i < line; i++) {
                number.add(br.readLine());
            }
            Collections.sort(number);
            //오름 차순 정렬하면 앞과만 비교하면 된다. (abc, abcd., bc, bcda )등과 같이 정렬 되기 떄문에
            sb.append(checkinNumber(line, number)).append("\n");
        }
        System.out.println(sb);
    }

    private static String checkinNumber(int line, List<String> number) {
        for (int i = 1; i < line; i++) {
            //이걸로 시작하는지만 확인
            if (number.get(i).startsWith(number.get(i - 1))) {
                return "NO";
            }
        }
        return "YES";
    }
}

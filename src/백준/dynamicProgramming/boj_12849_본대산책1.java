package 백준.dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_12849_본대산책1 {
    private static final int MOD = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int time = Integer.parseInt(br.readLine());
        long[] map = new long[8];
        map[0] = 1;
        //0정보 과학관,1 전산, 2 미래 ,3 신양,4한경직, 5 형납, 6.진리 7.학생회
        for (int i = 1; i <= time; i++) {
            map =  extracted(map);
        }

        System.out.println(map[0]);

    }

    private static long[] extracted(long[] map) {
        long[] map2 = new long[8];
        map2[0] = (map[1] + map[2]) % MOD;
        map2[1] = (map[0] + map[2] + map[3]) % MOD;
        map2[2] = (map[0] + map[1] + map[3] + map[4]) % MOD;
        map2[3] = (map[1] + map[2] + map[4] + map[6]) % MOD;
        map2[4] = (map[2] + map[3] + map[5] + map[6]) % MOD;
        map2[5] = (map[4] + map[7]) % MOD;
        map2[6] = (map[3] + map[4]+ map[7]) % MOD;
        map2[7] = (map[5] + map[6]) % MOD;
        return map2;
    }
}

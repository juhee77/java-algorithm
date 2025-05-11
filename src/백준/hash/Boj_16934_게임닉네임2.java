package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_16934_게임닉네임2 {
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> nameTotal = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            String input = br.readLine();
            nameTotal.put(input, nameTotal.getOrDefault(input, 0) + 1);
            if (!findAndPut(input, map)) {
                //이름 + 명수
                if (nameTotal.get(input) == 1) sb.append(input).append("\n");
                else sb.append(input + nameTotal.get(input)).append("\n");
            }
//            System.out.println(input + " " + map);
        }
        System.out.println(sb);
    }

    private static boolean findAndPut(String input, HashMap<String, Integer> map) {
        for (int i = 0; i < input.length(); i++) {
            String substring = input.substring(0, i + 1);
            if (!map.containsKey(substring)) {
                sb.append(substring).append("\n");
                for (int j = i; j < input.length(); j++) {
                    String temp = input.substring(0, j + 1);
                    map.put(temp, map.getOrDefault(temp, 0) + 1);
                }
                return true;
            }
        }
        return false;
    }

}

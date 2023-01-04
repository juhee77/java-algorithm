package inflearn.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class A_학습회장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int studentCnt = Integer.parseInt(br.readLine());
        char[] voted = br.readLine().toCharArray();

        HashMap<Character, Integer> votingResult = new HashMap<>();
        for (char vote : voted) {
            votingResult.put(vote, votingResult.getOrDefault(vote, 0) + 1);
        }

//        char ans = 0;
//        int max = Integer.MIN_VALUE;
//        for (char key : votingResult.keySet()) {
//            if (votingResult.get(key) > max) {
//                max = votingResult.get(key);
//                ans = key;
//            }
//        }
//        System.out.println(ans);

        List<Map.Entry<Character, Integer>> collect = votingResult.entrySet().stream().sorted(Map.Entry.comparingByValue()).collect(Collectors.toList());
        System.out.println(collect.get(collect.size()-1).getKey());

    }
}

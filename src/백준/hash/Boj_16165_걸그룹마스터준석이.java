package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16165_걸그룹마스터준석이 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashMap<String, String> teamMap = new HashMap<>();
        HashMap<String, List<String>> teamMemberMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            List<String> allMember = new ArrayList<>();
            String teamName = br.readLine();

            int memberCnt = Integer.parseInt(br.readLine());
            for (int j = 0; j < memberCnt; j++) {
                String name = br.readLine();
                teamMap.put(name, teamName);
                allMember.add(name);
            }


            Collections.sort(allMember);
            teamMemberMap.put(teamName, allMember);
        }

        while (m-- > 0) {
            String name = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 1) {
                sb.append(teamMap.get(name)).append("\n");
            }else{
                List<String> members = teamMemberMap.get(name);
                for (String member : members) {
                    sb.append(member).append("\n");
                }
            }

        }
        System.out.println(sb);


    }
}

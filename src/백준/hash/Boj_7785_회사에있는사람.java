package 백준.hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Boj_7785_회사에있는사람 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        HashSet<String> companyPeople = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        while (n-- > 0) {
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String cmd = st.nextToken();
            if (cmd.equals("enter")) {
                companyPeople.add(name);
            } else {
                companyPeople.remove(name);
            }
        }

        for (String s : companyPeople.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList())) {
            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}

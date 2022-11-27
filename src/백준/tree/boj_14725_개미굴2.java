package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class boj_14725_개미굴2 {
    private static class Node {
        private final HashMap<String, Node> child = new HashMap<>();

        private StringBuilder print(String prefix) {
            StringBuilder sb = new StringBuilder();
            List<String> collect = child.keySet().stream().sorted().collect(Collectors.toList());

            for (String now : collect) {
                sb.append(prefix).append(now).append("\n");
                sb.append(child.get(now).print(prefix + "--"));
            }
            return sb;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        Node root = new Node();

        while (line-- > 0) {
            Node now = root;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken());
            for (int i = 0; i < cnt; i++) {
                String temp = st.nextToken();
                if (!now.child.containsKey(temp)){
                    now.child.put(temp,new Node());
                }
                now = now.child.get(temp);
            }
        }
        System.out.println(root.print(""));
    }
}
/*
1
10 A B C D E F G H I J
A
--B
----C
------D
--------E
----------F
------------G
--------------H
----------------I
------------------J
 */
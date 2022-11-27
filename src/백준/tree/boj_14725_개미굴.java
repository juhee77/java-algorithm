package 백준.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class boj_14725_개미굴 {
    private static class Node {
        public String now;
        public List<Node> child;

        public Node(String now) {
            this.now = now;
            child = new ArrayList<>();
        }

        private void insert(String x, int cnt) {
            if (cnt == 0) return;

            int place = x.indexOf(" ") + 1;
            String in = x.substring(0, place).trim();
            if (place == 0) in = x;

            //System.out.println(x + " " + place+" "+in);
            boolean flag = true;
            for (Node node : child) {
                if (node.now.equals(in)) {
                    flag = false;
                    node.insert(x.substring(place), cnt - 1);
                    break;
                }

            }
            if (flag) {
                Node node = new Node(in);
                child.add(node);
                node.insert(x.substring(place), cnt - 1);
            }
        }

        private StringBuilder print(int cnt) {
            StringBuilder sb = new StringBuilder();
            child.sort(Comparator.comparing(o -> o.now));
            String prefix = "--".repeat(cnt);
            for (Node node : child) {
                sb.append(prefix).append(node.now).append("\n");
                sb.append(node.print(cnt + 1));
            }
            return sb;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "now='" + now + '\'' +
                    ", child=" + child +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int line = Integer.parseInt(br.readLine());
        Node root = new Node("");
        while (line-- > 0) {
            String temp = br.readLine();
            int place = temp.indexOf(" ") + 1;
            int cnt = Integer.parseInt(temp.substring(0, place).trim());
            String remain = temp.substring(place);
            root.insert(remain, cnt);
        }
        //System.out.println(root);
        System.out.println(root.print(0));
    }
}

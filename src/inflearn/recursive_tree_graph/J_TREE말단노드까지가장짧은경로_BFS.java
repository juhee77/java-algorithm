package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class J_TREE말단노드까지가장짧은경로_BFS {
    private static class Node {
        public int now;
        public Node left;
        public Node right;

        public Node(int data) {
            this.now = data;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();


        System.out.println(solution());
    }

    private static int  solution() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
//        root.right.left = new Node(4);
//        root.right.right = new Node(5);

        return bfs(root);
    }

    private static int bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        int level=0;
        while (!q.isEmpty()) {
            int qSize = q.size();
            for (int i = 0; i < qSize; i++) {
                Node now = q.poll();
                if(now==null) return level;
                q.add(now.left);
                q.add(now.right);
            }
            level++;
        }
        return 0;
    }
}

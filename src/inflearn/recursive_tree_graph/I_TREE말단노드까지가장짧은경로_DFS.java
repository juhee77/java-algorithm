package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class I_TREE말단노드까지가장짧은경로_DFS {
    private static class Node {
        public int now;
        public Node left;
        public Node right;

        public Node(int data) {
            this.now = data;
        }

        public void insert(int n) {
            if (n < this.now) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            } else {
                if (this.right == null)
                    this.right = new Node(n);
                else this.right.insert(n);
            }
        }
    }

    private static int min = 1000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        solution();
        System.out.println(min);
    }

    private static void solution() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
//        root.right.left = new Node(4);
//        root.right.right = new Node(5);

        dfs(-1,root);
    }

    private static void dfs(int i, Node root) {
        if(root==null) {
            min = Math.min(i, min);
            return;
        }
        dfs(i + 1, root.left);
        dfs(i + 1, root.right);
    }
}

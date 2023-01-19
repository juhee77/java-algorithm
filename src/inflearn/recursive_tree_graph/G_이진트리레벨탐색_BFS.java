package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G_이진트리레벨탐색_BFS {
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        solution();
    }

    private static void solution() {
        Node root = new Node(1);
        root.left= new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        //레밸 탐색
        levelSearch(root);
        System.out.println();
    }

    private static void levelSearch(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; i++) {
                Node now = q.poll();
                System.out.println(now.now + " ");
                if(now.left!=null) q.add(now.left);
                if(now.right!=null) q.add(now.right);
            }
        }
    }

}

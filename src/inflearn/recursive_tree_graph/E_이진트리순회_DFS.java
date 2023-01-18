package inflearn.recursive_tree_graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class E_이진트리순회_DFS {
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

        //전휘순회
        preOrder(root);
        System.out.println();
        //중위순회
        order(root);
        System.out.println();
        //후위순회
        lastOrder(root);
    }

    private static void preOrder(Node root) {
        if (root == null) return;
        System.out.print(root.now+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    private static void order(Node root) {
        if (root == null) return;
        order(root.left);
        System.out.print(root.now+" ");
        order(root.right);
    }

    private static void lastOrder(Node root) {
        if (root == null) return;
        lastOrder(root.left);
        lastOrder(root.right);
        System.out.print(root.now+" ");
    }
}

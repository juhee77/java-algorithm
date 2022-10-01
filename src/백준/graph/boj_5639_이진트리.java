package 백준.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class boj_5639_이진트리 {
    private static StringBuilder sb = new StringBuilder();

    static class Node {
        int now;
        Node left;
        Node right;

        Node(int now) {
            this.now = now;
        }

        public void insert(int n) {
            if (n < this.now) {
                if (this.left == null)
                    this.left = new Node(n);
                else this.left.insert(n);
            }
            else{
                if(this.right==null)
                    this.right= new Node(n);
                else this.right.insert(n);
            }
        }

    }

    public static void print(Node node) {
        if(node == null) return;

        print(node.left);
        print(node.right);
        sb.append(node.now+"\n");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Node root = new Node(Integer.parseInt(br.readLine()));

        //입력구간 (inorder)
        while (true) {
            String temp = br.readLine();
            if (temp == null || temp.equals("")) break;
            root.insert(Integer.parseInt(temp));
        }

        print(root);
        System.out.println(sb);
    }
}

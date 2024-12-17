package 백준.trie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_16934_게임닉네임 {
    private static Trie trie = new Trie();
    private static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        while (n-- > 0) {
            String now = br.readLine();
            if (insertWithShortestPrefix(now)) continue;

            if (!trie.search(now)) {
                sb.append(now);
                trie.insert(now);
            } else {
                int suffix = 2;
                Trie.TrieNode node = trie.getNode(now);
                while (true) {
                    String suffixStr = String.valueOf(suffix);
                    if (!trie.search(node, suffixStr)) {
                        trie.insert(node, suffixStr);
                        sb.append(now).append(suffix);
                        break;
                    }
                    suffix++;
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static boolean insertWithShortestPrefix(String word) {
        Trie.TrieNode current = trie.getRoot();
        StringBuilder prefix = new StringBuilder();
        for (char c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                trie.insert(prefix.toString()); // 접두사가 없다면 트라이에 삽입
                sb.append(prefix);
                return true;
            }
            prefix.append(c);
            current = current.children.get(c);
        }
        return false; // 모든 접두사가 이미 존재
    }

    public static class Trie {
        private static class TrieNode {
            HashMap<Character, TrieNode> children = new HashMap<>();
            boolean isEndOfWord = false;
        }

        private final TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public TrieNode getRoot() {
            return root;
        }

        public void insert(String word) {
            insert(root, word);
        }

        public void insert(TrieNode node, String word) {
            TrieNode current = node;
            for (char c : word.toCharArray()) {
                current = current.children.computeIfAbsent(c, k -> new TrieNode());
            }
            current.isEndOfWord = true;
        }

        public boolean search(String word) {
            return search(root, word);
        }

        public boolean search(TrieNode node, String word) {
            TrieNode current = node;
            for (char c : word.toCharArray()) {
                current = current.children.get(c);
                if (current == null) return false;
            }
            return current.isEndOfWord;
        }

        public TrieNode getNode(String word) {
            TrieNode current = root;
            for (char c : word.toCharArray()) {
                current = current.children.get(c);
                if (current == null) return null;
            }
            return current;
        }
    }
}
